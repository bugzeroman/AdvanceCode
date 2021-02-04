package edu.yuwen.dp.create.factory.more.di.scene;

public class RedisCounter {
    private String ipAddress;

    private int port;

    public RedisCounter(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public String toString() {
        return "RedisCounter [ipAddress=" + ipAddress + ", port=" + port + "]";
    }
}
