package co.reaf.design.ebay.api.finding.parameters;

/**
 * Created by iabramov on 17/09/2015.
 */
public class CampaignIdParameterImpl implements Parameter<String>{
    private String campaignId;

    @Override
    public void setParamValue(String value) {
        campaignId=value;
    }

    @Override
    public String getParamValue() {
        return campaignId;
    }
}
