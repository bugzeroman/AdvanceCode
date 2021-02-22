package edu.yuwen.dp.structure.adapter.more.unify;

public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {
    private BSensitiveWordsFilter bFilter;

    @Override
    public String filter(String text) {
        String maskedText = bFilter.filter(text);
        return maskedText;
    }

}
