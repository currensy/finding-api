package com.reaf.design.ebay.api.finding.domain.item;

import java.util.List;

/**
 * Created by iabramov on 19/09/2015.
 */
public class PrimaryCategory {

    private List<String> categoryId;
    private List<String> categoryName;

    public List<String> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(List<String> categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(List<String> categoryName) {
        this.categoryName = categoryName;
    }
}
