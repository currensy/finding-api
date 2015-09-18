package com.reaf.design.ebay.api.finding.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by iabramov on 18/09/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private List<String> itemId;
    private List<String> title;
    private List<String> globalId;


    public List<String> getItemId() {
        return itemId;
    }

    public void setItemId(List<String> itemId) {
        this.itemId = itemId;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getGlobalId() {
        return globalId;
    }

    public void setGlobalId(List<String> globalId) {
        this.globalId = globalId;
    }
}
