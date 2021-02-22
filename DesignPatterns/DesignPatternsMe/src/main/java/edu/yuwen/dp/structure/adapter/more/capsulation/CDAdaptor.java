package edu.yuwen.dp.structure.adapter.more.capsulation;

/**
 * 4.适配器模式（结构性） 应用场景举例
 * 
 * 1.类适配器: 基于继承
 *
 * Demo:1.封装有缺陷的接口设计
 * 注意：适配器类的命名不一定非得末尾带Adaptor
 */
public class CDAdaptor extends CD implements ITarget {
    @Override
    public void function1() {
        super.staticFunction1();
    }

    @Override
    public void function2() {
        super.uglyNamingFunction2();
    }

    @Override
    public void function3(ParamsWrapperDefinition paramsWrapper) {
        super.tooManyParamsFunction3(paramsWrapper.getParamA(), paramsWrapper.getParamB());
    }

    @Override
    public void function4() {
        // ...reimplement it...
    }
}
