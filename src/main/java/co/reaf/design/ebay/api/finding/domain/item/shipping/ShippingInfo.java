package co.reaf.design.ebay.api.finding.domain.item.shipping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by iabramov on 19/09/2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingInfo {

    private List<ShippingServiceCost> shippingServiceCost;
    private List<String> shippingType;
    private List<String> shipToLocations;
    private List<String> expeditedShipping;
    private List<String> oneDayShippingAvailable;
    private List<String> handlingTime;

    public List<ShippingServiceCost> getShippingServiceCost() {
        return shippingServiceCost;
    }

    public void setShippingServiceCost(List<ShippingServiceCost> shippingServiceCost) {
        this.shippingServiceCost = shippingServiceCost;
    }

    public List<String> getShippingType() {
        return shippingType;
    }

    public void setShippingType(List<String> shippingType) {
        this.shippingType = shippingType;
    }

    public List<String> getShipToLocations() {
        return shipToLocations;
    }

    public void setShipToLocations(List<String> shipToLocations) {
        this.shipToLocations = shipToLocations;
    }

    public List<String> getExpeditedShipping() {
        return expeditedShipping;
    }

    public void setExpeditedShipping(List<String> expeditedShipping) {
        this.expeditedShipping = expeditedShipping;
    }

    public List<String> getOneDayShippingAvailable() {
        return oneDayShippingAvailable;
    }

    public void setOneDayShippingAvailable(List<String> oneDayShippingAvailable) {
        this.oneDayShippingAvailable = oneDayShippingAvailable;
    }

    public List<String> getHandlingTime() {
        return handlingTime;
    }

    public void setHandlingTime(List<String> handlingTime) {
        this.handlingTime = handlingTime;
    }
}
