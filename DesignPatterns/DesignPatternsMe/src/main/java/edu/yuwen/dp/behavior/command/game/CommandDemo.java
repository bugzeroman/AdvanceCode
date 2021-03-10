package edu.yuwen.dp.behavior.command.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 9.命令模式（行为型） 
 *
 * Demo: 整个手游后端服务器轮询获取客户端发来的请求，
 * 获取到请求之后，借助命令模式，
 * 把请求包含的数据和处理逻辑封装为命令对象，
 * 并存储在内存队列中。
 * 然后，再从队列中取出一定数量的命令来执行。
 * 执行完成之后，再重新开始新的一轮轮询。
 */
public class CommandDemo {
    // 每次批量执行的命令数量
    private static final int MAX_HANDLED_REQ_COUNT_PER_LOOP = 100;
    private Queue<Command> queue = new LinkedList<>();

    public void mainloop() {
        while (true) {
            // 省略从epoll或者select中获取数据，并封装成Request的逻辑，
            // 注意设置超时时间，如果很长时间没有接收到请求，就继续下面的逻辑处理。
            List<Request> requests = new ArrayList<>();

            // 封装请求为命令，并且进入队列排队
            for (Request request : requests) {
                Event event = request.getEvent();
                Command command = null;
                if (event.equals(Event.GOT_DIAMOND)) {
                    command = new GotDiamondCommand(/* 数据 */);
                } else if (event.equals(Event.GOT_STAR)) {
                    command = new GotStartCommand(/* 数据 */);
                } else if (event.equals(Event.HIT_OBSTACLE)) {
                    command = new HitObstacleCommand(/* 数据 */);
                } else if (event.equals(Event.ARCHIVE)) {
                    command = new ArchiveCommand(/* 数据 */);
                } // ...一堆else if...

                queue.add(command);
            }

            // 批量执行命令
            int handledCount = 0;
            while (handledCount < MAX_HANDLED_REQ_COUNT_PER_LOOP) {
                if (queue.isEmpty()) {
                    break;
                }
                Command command = queue.poll();
                command.execute();
                handledCount++;
            }
        }
    }
}