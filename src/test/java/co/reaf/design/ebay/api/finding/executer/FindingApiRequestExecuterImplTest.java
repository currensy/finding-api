package co.reaf.design.ebay.api.finding.executer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

/**
 * Created by iabramov on 19/09/2015.
 */
@ContextConfiguration("classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class FindingApiRequestExecuterImplTest {

    @Autowired
    private RequestExecuter findingApiRequestExecuter;



    @Test
    public void testExec() throws Exception {

        String stringUrl = "http://svcs.ebay.com/services/search/FindingService/v1?keywords=iphone+6s&affiliate.networkId=9&SERVICE-VERSION=1.0.0&SECURITY-APPNAME=Reafco980-218b-41c2-b3af-93890dc7786&RESPONSE-DATA-FORMAT=JSON&OPERATION-NAME=findItemsByKeywords&affiliate.trackingId=5337737097&paginationInput.entriesPerPage=1";
        JsonNode jsonNodeResponse = (JsonNode) findingApiRequestExecuter.exec(stringUrl, JsonNode.class);
        assertNotNull(jsonNodeResponse);

    }
}