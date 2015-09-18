package com.reaf.design.ebay.api.finding;

import com.reaf.design.ebay.api.finding.enums.EbayGlobalId;
import com.reaf.design.ebay.api.finding.enums.FindingApiResponseType;
import com.reaf.design.ebay.api.finding.operation.FindItemsByKeywordsOperation;

import com.reaf.design.ebay.api.finding.operation.FindItemsByProductOperation;

/**
 * Created by iabramov on 11/09/2015.
 */
public class Main {


    public static void main(String[] args) {


        ApiAccount apiAccount = new ApiAccount("Reafco980-218b-41c2-b3af-93890dc7786");
        PartnerAccount partnerAccount = new PartnerAccount("5337737097", "9");
        ApiContext apiContext = new ApiContext();
        apiContext.setApiAccount(apiAccount);
        apiContext.setPartnerAccount(partnerAccount);
        FindItemsByKeywordsOperation findItemsByKeywordsOperation = new FindItemsByKeywordsOperation("iphone 6s");
        apiContext.setOperation(findItemsByKeywordsOperation);
        apiContext.setResponseType(FindingApiResponseType.JSON);
        apiContext.setGlobalId(EbayGlobalId.UK);
        apiContext.setEntriesPerPage("10");
        FindingApiNg findingApiNg = new FindingApiNg(apiContext);
        findingApiNg.build();
        findItemsByKeywordsOperation.setOperationInputValue("ralph lauren polo shirt");
        apiContext.setOperation(findItemsByKeywordsOperation);
        findingApiNg.build();
        FindItemsByProductOperation findItemsByProductOperation = new FindItemsByProductOperation("85968596895869");
        apiContext.setOperation(findItemsByProductOperation);
        findingApiNg.setApiContext(apiContext);
        findingApiNg.build();

    }
}
