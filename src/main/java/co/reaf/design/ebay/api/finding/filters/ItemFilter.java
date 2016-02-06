package co.reaf.design.ebay.api.finding.filters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iabramov on 06/02/2016.
 */
public class ItemFilter {
    private Map<String, String> filters;

    public ItemFilter() {
        this.filters = new HashMap<>();
    }

    public Map<String, String> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, String> filters) {
        this.filters = filters;
    }
}
