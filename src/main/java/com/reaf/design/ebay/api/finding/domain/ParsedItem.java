package com.reaf.design.ebay.api.finding.domain;

/**
 * Created by iabramov on 18/09/2015.
 */
public class ParsedItem {

    private String itemId;
    private String title;
    private String globalId;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }
}
