package com.reaf.design.ebay.api.finding.domain.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.reaf.design.ebay.api.finding.domain.item.condition.Condition;
import com.reaf.design.ebay.api.finding.domain.item.listing.ListingInfo;
import com.reaf.design.ebay.api.finding.domain.item.selling.SellingStatus;
import com.reaf.design.ebay.api.finding.domain.item.shipping.ShippingInfo;

import java.util.List;

/**
 * Created by iabramov on 18/09/2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private List<String> itemId;
    private List<String> title;
    private List<String> globalId;
    private List<PrimaryCategory> primaryCategory;
    private List<String> galleryURL;
    private List<String> viewItemURL;
    private List<String> paymentMethod;
    private List<String> autoPay;
    private List<String> postalCode;
    private List<String> location;
    private List<String> country;
    private List<String> returnsAccepted;
    private List<String> isMultiVariationListing;
    private List<String> topRatedListing;
    private List<ShippingInfo> shippingInfo;
    private List<SellingStatus> sellingStatus;
    private List<ListingInfo> listingInfo;
    private List<Condition> condition;


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

    public List<PrimaryCategory> getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(List<PrimaryCategory> primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public List<String> getGalleryURL() {
        return galleryURL;
    }

    public void setGalleryURL(List<String> galleryURL) {
        this.galleryURL = galleryURL;
    }

    public List<String> getViewItemURL() {
        return viewItemURL;
    }

    public void setViewItemURL(List<String> viewItemURL) {
        this.viewItemURL = viewItemURL;
    }

    public List<String> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<String> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<String> getAutoPay() {
        return autoPay;
    }

    public void setAutoPay(List<String> autoPay) {
        this.autoPay = autoPay;
    }

    public List<String> getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(List<String> postalCode) {
        this.postalCode = postalCode;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getReturnsAccepted() {
        return returnsAccepted;
    }

    public void setReturnsAccepted(List<String> returnsAccepted) {
        this.returnsAccepted = returnsAccepted;
    }

    public List<String> getIsMultiVariationListing() {
        return isMultiVariationListing;
    }

    public void setIsMultiVariationListing(List<String> isMultiVariationListing) {
        this.isMultiVariationListing = isMultiVariationListing;
    }

    public List<String> getTopRatedListing() {
        return topRatedListing;
    }

    public void setTopRatedListing(List<String> topRatedListing) {
        this.topRatedListing = topRatedListing;
    }

    public List<ShippingInfo> getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(List<ShippingInfo> shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public List<SellingStatus> getSellingStatus() {
        return sellingStatus;
    }

    public void setSellingStatus(List<SellingStatus> sellingStatus) {
        this.sellingStatus = sellingStatus;
    }

    public List<ListingInfo> getListingInfo() {
        return listingInfo;
    }

    public void setListingInfo(List<ListingInfo> listingInfo) {
        this.listingInfo = listingInfo;
    }

    public List<Condition> getCondition() {
        return condition;
    }

    public void setCondition(List<Condition> condition) {
        this.condition = condition;
    }
}
