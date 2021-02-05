package edu.yuwen.dp.create.builder.v2;

/**
 * 1.建造者模式
 * 
 * 1.第二种实现方式，Builder为外部类 ResourcePoolConfigBuilder
 *
 * Demo:定义一个资源池配置类 ResourcePoolConfig，参数有的必填，有的选填，参数之间有依赖关系
 */
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    ResourcePoolConfig(ResourcePoolConfigBuilder builder) {
        this.name = builder.getName();
        this.maxTotal = builder.getMaxTotal();
        this.maxIdle = builder.getMaxIdle();
        this.minIdle = builder.getMinIdle();
    }

    public String getName() {
        return name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

}
