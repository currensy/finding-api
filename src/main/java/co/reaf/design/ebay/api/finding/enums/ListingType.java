package co.reaf.design.ebay.api.finding.enums;

/**
 * Created by iabramov on 06/02/2016.
 */
public enum ListingType {
    FIXED_PRICE("FixedPrice");

    private final String listingType;

    ListingType(String listingType) {
        this.listingType = listingType;
    }

    public String getListingType() {
        return listingType;
    }
}
