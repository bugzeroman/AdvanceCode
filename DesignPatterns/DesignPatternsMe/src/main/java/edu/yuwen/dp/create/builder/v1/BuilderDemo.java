package edu.yuwen.dp.create.builder.v1;

/**
 * 3.建造者模式 使用示例
 */
public class BuilderDemo {
    public static void main(String[] args) {
        // 使用建造者模式正常创建
        ResourcePoolConfig config1 = new ResourcePoolConfig.Builder().setName("dbconnectionpool").setMaxTotal(16)
                .setMaxIdle(10).setMinIdle(5).build();
        System.out.println(config1);

        // 这段代码会抛出IllegalArgumentException，因为minIdle>maxIdle
        ResourcePoolConfig config2 = new ResourcePoolConfig.Builder().setName("dbconnectionpool").setMaxTotal(16)
                .setMaxIdle(10).setMinIdle(12).build();
        System.out.println(config2);
    }
}
