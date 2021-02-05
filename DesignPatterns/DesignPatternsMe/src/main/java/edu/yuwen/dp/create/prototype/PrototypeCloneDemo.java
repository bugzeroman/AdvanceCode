package edu.yuwen.dp.create.prototype;

import java.util.HashMap;
import java.util.List;

/**
 * 4.原型模式  
 * 
 * 1.不常用，非完整Demo,这里通过Java的克隆的浅拷贝和深拷贝举例
 *
 * Demo:假设数据库中存储了10万条“搜索关键词”，
 * 系统 A 在启动的时候会加载这份数据到内存中，
 * 系统 B专门用来分析搜索日志，更新这份内存，
 * 需要保证，任何时刻，
 * 系统 A 中的所有数据都必须是同一个版本的。
 */
public class PrototypeCloneDemo {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    /**
     * 可以先采用浅拷贝的方式创建 newKeywords。
     * 对于需要更新的 SearchWord 对象，
     * 我们再使用深度拷贝的方式创建一份新的对象，
     * 替换 newKeywords中的老对象。
     * 相对来说需要更新的数据是很少的。
     */
    public void refresh() {
        // 浅拷贝
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords.clone();

        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                newKeywords.remove(searchWord.getKeyword());
            }
            newKeywords.put(searchWord.getKeyword(), searchWord);
        }

        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 从数据库中取出更新时间>lastUpdateTime的数据
        return null;
    }
}