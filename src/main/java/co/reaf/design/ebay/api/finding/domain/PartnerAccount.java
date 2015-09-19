package co.reaf.design.ebay.api.finding.domain;

import co.reaf.design.ebay.api.finding.annotation.ApiCallParam;
import co.reaf.design.ebay.api.finding.enums.FindingApiParam;
import co.reaf.design.ebay.api.finding.parameters.CampaignIdParameterImpl;
import co.reaf.design.ebay.api.finding.parameters.NetworkIdParameterImpl;

/**
 * Created by iabramov on 17/09/2015.
 */

public class PartnerAccount {


    @ApiCallParam(FindingApiParam.TRACKING_ID)
    private CampaignIdParameterImpl campaignIdParameter;
    @ApiCallParam(FindingApiParam.NETWORK_ID)
    private NetworkIdParameterImpl networkIdParameter;




    public PartnerAccount(String campaignId, String networkId){
        setCampaignId(campaignId);
        setNetworkId(networkId);
    }

    public CampaignIdParameterImpl getCampaignId() {
        return campaignIdParameter;
    }

    public void setCampaignId(String campaignId) {
        CampaignIdParameterImpl campaignIdParameter = new CampaignIdParameterImpl();
        campaignIdParameter.setParamValue(campaignId);
        this.campaignIdParameter=campaignIdParameter;

    }

    public NetworkIdParameterImpl getNetWorkId(){
        return networkIdParameter;
    }


    public void setNetworkId(String networkId) {
        NetworkIdParameterImpl networkIdParameter = new NetworkIdParameterImpl();
        networkIdParameter.setParamValue(networkId);
        this.networkIdParameter = networkIdParameter;
    }
}
