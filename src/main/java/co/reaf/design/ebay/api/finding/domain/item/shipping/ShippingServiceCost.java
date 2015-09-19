package co.reaf.design.ebay.api.finding.domain.item.shipping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by iabramov on 19/09/2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingServiceCost {

    @JsonProperty("@currencyId")
    private String currencyId;
    @JsonProperty("__value__")
    private String value;

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
