package com.reaf.design.ebay.api.finding.domain.item.condition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by iabramov on 19/09/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition {
    private List<String> conditionId;
    private List<String> conditionDisplayName;

    public List<String> getConditionId() {
        return conditionId;
    }

    public void setConditionId(List<String> conditionId) {
        this.conditionId = conditionId;
    }

    public List<String> getConditionDisplayName() {
        return conditionDisplayName;
    }

    public void setConditionDisplayName(List<String> conditionDisplayName) {
        this.conditionDisplayName = conditionDisplayName;
    }
}
