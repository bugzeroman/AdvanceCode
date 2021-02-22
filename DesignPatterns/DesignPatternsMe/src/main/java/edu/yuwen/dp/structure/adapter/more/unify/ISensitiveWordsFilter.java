package edu.yuwen.dp.structure.adapter.more.unify;

//使用适配器模式进行改造
//统一接口定义
public interface ISensitiveWordsFilter {
    String filter(String text);
}
