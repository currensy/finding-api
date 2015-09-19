package com.reaf.design.ebay.api.finding.domain.item.selling;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by iabramov on 19/09/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SellingStatus {

    private List<CurrentPrice> currentPrice;
    private List<CurrentPrice> convertedCurrentPrice;
    private List<String> sellingState;
    private List<String> timeLeft;

    public List<CurrentPrice> getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(List<CurrentPrice> currentPrice) {
        this.currentPrice = currentPrice;
    }

    public List<CurrentPrice> getConvertedCurrentPrice() {
        return convertedCurrentPrice;
    }

    public void setConvertedCurrentPrice(List<CurrentPrice> convertedCurrentPrice) {
        this.convertedCurrentPrice = convertedCurrentPrice;
    }

    public List<String> getSellingState() {
        return sellingState;
    }

    public void setSellingState(List<String> sellingState) {
        this.sellingState = sellingState;
    }

    public List<String> getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(List<String> timeLeft) {
        this.timeLeft = timeLeft;
    }
}
