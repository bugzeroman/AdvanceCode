package edu.yuwen.dp.create.singleton.more.multiton;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 1.单例模式的变种，多例模式，实例数量有上限，不能无限创建
 * 
 *
 * Demo:提供后端服务的服务器数量，限制为只有3台，只能创建3个实例
 */
public class BackendServer {
    private static final int SERVER_COUNT = 3;

    private static final Map<Long, BackendServer> serverInstances = new HashMap<>();

    @SuppressWarnings("unused")
    private long serverNo;
    @SuppressWarnings("unused")
    private String serverAddress;

    static {
        serverInstances.put(1L, new BackendServer(1L, "192.134.22.138:8080"));
        serverInstances.put(2L, new BackendServer(2L, "192.134.22.139:8080"));
        serverInstances.put(3L, new BackendServer(3L, "192.134.22.140:8080"));
    }

    private BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public BackendServer getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }

    public BackendServer getRandomInstance() {
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT) + 1;
        return serverInstances.get(new Long(no));
    }
}
