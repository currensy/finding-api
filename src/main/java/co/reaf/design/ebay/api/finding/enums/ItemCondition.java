package co.reaf.design.ebay.api.finding.enums;

/**
 * Created by iabramov on 06/02/2016.
 */
public enum ItemCondition {
    NEW("New");

    private final String condition;

    ItemCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }
}
