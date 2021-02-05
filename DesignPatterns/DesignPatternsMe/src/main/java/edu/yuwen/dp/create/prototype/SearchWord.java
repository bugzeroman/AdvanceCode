package edu.yuwen.dp.create.prototype;

/**
 * 搜索关键词信息，每条信息包含关键词、关键词被搜索的次数、信息最近被更新的时间等。
 *
 */
public class SearchWord {

    private String keyword;

    private Long lastUpdateTime;

    private Long count;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
