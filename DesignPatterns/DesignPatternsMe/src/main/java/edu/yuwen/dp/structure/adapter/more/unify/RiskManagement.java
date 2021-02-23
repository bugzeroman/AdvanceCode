package edu.yuwen.dp.structure.adapter.more.unify;

import java.util.ArrayList;
import java.util.List;

/**
 * 4.适配器模式（结构型） 应用场景举例
 * 
 * 2.对象适配器：基于组合
 *
 * Demo:2.统一多个类的接口设计
 */
// 扩展性更好，更加符合开闭原则，如果添加一个新的敏感词过滤系统，
// 这个类完全不需要改动；而且基于接口而非实现编程，代码的可测试性更好。
public class RiskManagement {
    private List<ISensitiveWordsFilter> filters = new ArrayList<>();

    public void addSensitiveWordsFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }

    public String filterSensitiveWords(String text) {
        String maskedText = text;
        for (ISensitiveWordsFilter filter : filters) {
            maskedText = filter.filter(maskedText);
        }
        return maskedText;
    }
}

//// 未使用适配器模式之前的代码：代码的可测试性、扩展性不好
// public class RiskManagement {
// private ASensitiveWordsFilter aFilter = new ASensitiveWordsFilter();
// private BSensitiveWordsFilter bFilter = new BSensitiveWordsFilter();
// private CSensitiveWordsFilter cFilter = new CSensitiveWordsFilter();
//
// public String filterSensitiveWords(String text) {
// String maskedText = aFilter.filterSexyWords(text);
// maskedText = aFilter.filterPoliticalWords(maskedText);
// maskedText = bFilter.filter(maskedText);
// maskedText = cFilter.filter(maskedText, "***");
// return maskedText;
// }
// }
