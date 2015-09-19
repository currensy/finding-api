package co.reaf.design.ebay.api.finding;

import co.reaf.design.ebay.api.finding.domain.ApiContext;
import co.reaf.design.ebay.api.finding.domain.PartnerAccount;
import co.reaf.design.ebay.api.finding.domain.response.Response;
import co.reaf.design.ebay.api.finding.enums.EbayGlobalId;
import co.reaf.design.ebay.api.finding.enums.FindingApiResponseType;
import co.reaf.design.ebay.api.finding.domain.ApiAccount;
import co.reaf.design.ebay.api.finding.operation.FindItemsByCategory;
import co.reaf.design.ebay.api.finding.operation.FindItemsByKeywordsOperation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by iabramov on 11/09/2015.
 */
public class Main {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        FindingApi findingApi = (FindingApi) context.getBean("findingApi");


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
        findingApi.setApiContext(apiContext);
        try {
            Response response = findingApi.execOperation();
            System.out.println(response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        FindItemsByCategory findItemsByCategory = new FindItemsByCategory("9355");
        apiContext.setOperation(findItemsByCategory);
        findingApi.setApiContext(apiContext);
        try {
            Response response = findingApi.execOperation();
            System.out.println(response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
