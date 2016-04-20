package co.reaf.design.ebay.api.finding;

import co.reaf.design.ebay.api.finding.domain.ApiContext;
import co.reaf.design.ebay.api.finding.domain.PartnerAccount;
import co.reaf.design.ebay.api.finding.domain.response.Response;
import co.reaf.design.ebay.api.finding.enums.ItemCondition;
import co.reaf.design.ebay.api.finding.enums.EbayGlobalId;
import co.reaf.design.ebay.api.finding.enums.FindingApiResponseType;
import co.reaf.design.ebay.api.finding.domain.ApiAccount;
import co.reaf.design.ebay.api.finding.enums.ListingType;
import co.reaf.design.ebay.api.finding.exception.FindingApiException;
import co.reaf.design.ebay.api.finding.operation.FindItemsByKeywordsOperation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by iabramov on 11/09/2015.
 */
public class Main {


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        FindingApi findingApi = (FindingApi) context.getBean("findingApi");


        ApiAccount apiAccount = new ApiAccount("XXXXX");
        PartnerAccount partnerAccount = new PartnerAccount("XXXX", "X");
        FindItemsByKeywordsOperation findItemsByKeywordsOperation = new FindItemsByKeywordsOperation("iphone 6s 64GB");
        ApiContext apiContext = new ApiContext.Builder(apiAccount)
                .operation(findItemsByKeywordsOperation)
                .globalId(EbayGlobalId.US)
                .partnerAccount(partnerAccount)
                .responseType(FindingApiResponseType.JSON)
                .entriesPerPage("10")
                .build();

        
        apiContext.setCondition(ItemCondition.NEW);
        apiContext.setListingType(ListingType.FIXED_PRICE);
        apiContext.setAvailableToLocation("IL");
        findingApi.setApiContext(apiContext);


        try {
            Response response = findingApi.execOperation();
            System.out.println(response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (FindingApiException e) {
            e.printStackTrace();
        }
        /*FindItemsByCategory findItemsByCategory = new FindItemsByCategory("9355");
        apiContext.setOperation(findItemsByCategory);
        findingApi.setApiContext(apiContext);
        try {
            Response response = findingApi.execOperation();
            System.out.println(response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

    }
}
