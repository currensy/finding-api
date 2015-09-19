package co.reaf.design.ebay.api.finding.executer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by iabramov on 18/09/2015.
 */

@Component
public class FindingApiRequestExecuterImpl implements RequestExecuter {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;



    @Override
    public Object exec(Object request, Class type) {
        String stringResponse = restTemplate.getForObject((String) request, String.class);
        try {
            return convertStringResponseToObject(stringResponse, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Object convertStringResponseToObject(String response, Class type) throws IOException {
        Object responseObject = objectMapper.readValue(response, type);
        return responseObject;
    }
}
