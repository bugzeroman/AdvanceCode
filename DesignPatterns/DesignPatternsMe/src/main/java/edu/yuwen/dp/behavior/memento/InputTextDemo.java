package edu.yuwen.dp.behavior.memento;

import java.util.Scanner;

/**
 * 8.备忘录者模式（行为型） 
 *
 * Demo: 分布添加文本，中间可以使用撤回上一次添加的文本
 */
public class InputTextDemo {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotsHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equals(":list")) {
                System.out.println(inputText.getText());
            } else if (input.equals(":undo")) {
                Snapshot snapshot = snapshotsHolder.popSnapshot();
                inputText.restoreSnapshot(snapshot);
            } else {
                snapshotsHolder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
        scanner.close();
    }
}
