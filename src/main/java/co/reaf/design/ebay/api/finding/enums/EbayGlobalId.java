package co.reaf.design.ebay.api.finding.enums;

/**
 * Created by iabramov on 11/09/2015.
 */
public enum EbayGlobalId {
    US("EBAY-US"),UK("EBAY-GB"),
    AT("EBAY-AT"),
    AU("EBAY-AU"),
    CH("EBAY-CH"),
    DE("EBAY-DE"),
    CA("EBAY-ENCA"),
    ES("EBAY-ES"),
    FR("EBAY-FR"),
    BE("EBAY-FRBE"),
    //CA("EBAY-FRCA")
    GB("EBAY-GB"),
    HK("EBAY-HK"),
    IE("EBAY-IE"),
    IN("EBAY-IN"),
    IT("EBAY-IT"),
//    US("EBAY-MOTOR")
    MY("EBAY-MY"),
    NL("EBAY-NL"),
//    BE("EBAY-NLBE")
    PH("EBAY-PH"),
    PL("EBAY-PL"),
    SG("EBAY-SG");



    private String globalId;

    EbayGlobalId(String globalId) {
        this.globalId=globalId;
    }

    public String getGlobalId(){
        return globalId;
    }
}
