package edu.yuwen.dp.create.factory.more.di.scene;

public class RateLimiter {
    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test() {
        System.out.println("Hello World!");
    }

    @Override
    public String toString() {
        return "RateLimiter [redisCounter=" + redisCounter + "]";
    }
}