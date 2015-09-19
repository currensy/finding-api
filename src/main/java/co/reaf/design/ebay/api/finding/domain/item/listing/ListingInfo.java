package co.reaf.design.ebay.api.finding.domain.item.listing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by iabramov on 19/09/2015.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingInfo {

    private List<String> bestOfferEnabled;
    private List<String> buyItNowAvailable;
    private List<String> startTime;
    private List<String> endTime;
    private List<String> listingType;
    private List<String> gift;

    public List<String> getBestOfferEnabled() {
        return bestOfferEnabled;
    }

    public void setBestOfferEnabled(List<String> bestOfferEnabled) {
        this.bestOfferEnabled = bestOfferEnabled;
    }

    public List<String> getBuyItNowAvailable() {
        return buyItNowAvailable;
    }

    public void setBuyItNowAvailable(List<String> buyItNowAvailable) {
        this.buyItNowAvailable = buyItNowAvailable;
    }

    public List<String> getStartTime() {
        return startTime;
    }

    public void setStartTime(List<String> startTime) {
        this.startTime = startTime;
    }

    public List<String> getEndTime() {
        return endTime;
    }

    public void setEndTime(List<String> endTime) {
        this.endTime = endTime;
    }

    public List<String> getListingType() {
        return listingType;
    }

    public void setListingType(List<String> listingType) {
        this.listingType = listingType;
    }

    public List<String> getGift() {
        return gift;
    }

    public void setGift(List<String> gift) {
        this.gift = gift;
    }
}
