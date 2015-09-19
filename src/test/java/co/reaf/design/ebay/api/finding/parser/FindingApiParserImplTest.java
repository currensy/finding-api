package co.reaf.design.ebay.api.finding.parser;

import co.reaf.design.ebay.api.finding.domain.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.reaf.design.ebay.api.finding.domain.item.ParsedItem;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by iabramov on 19/09/2015.
 */
public class FindingApiParserImplTest {

    @Test
    public void testParse() throws Exception {
        String jsonMock = "[{\"ack\": [\"Success\"], \"version\": [\"1.13.0\"], \"timestamp\": [\"2015-09-19T09:25:41.500Z\"], \"searchResult\": [{\"@count\": \"1\", \"item\": [{\"itemId\": [\"231693212588\"], \"title\": [\"Apple iPhone 6S Plus - 64GB - Gold Smartphone (UNLOCKED)\"], \"globalId\": [\"EBAY-US\"], \"primaryCategory\": [{\"categoryId\": [\"9355\"], \"categoryName\": [\"Cell Phones & Smartphones\"] } ], \"galleryURL\": [\"http://thumbs1.ebaystatic.com/m/muihpDdlu3NxolXLhhTs16g/140.jpg\"], \"viewItemURL\": [\"http://rover.ebay.com/rover/1/711-53200-19255-0/1?ff3=2&toolid=10041&campid=5337737097&customid=&lgeo=1&vectorid=229466&item=231693212588\"], \"productId\": [{\"@type\": \"ReferenceID\", \"__value__\": \"216195855\"} ], \"paymentMethod\": [\"PayPal\"], \"autoPay\": [\"false\"], \"postalCode\": [\"60540\"], \"location\": [\"Naperville,IL,USA\"], \"country\": [\"US\"], \"shippingInfo\": [{\"shippingServiceCost\": [{\"@currencyId\": \"USD\", \"__value__\": \"0.0\"} ], \"shippingType\": [\"FlatDomesticCalculatedInternational\"], \"shipToLocations\": [\"US\", \"CA\", \"GB\", \"AU\", \"AT\", \"BE\", \"FR\", \"DE\", \"IT\", \"JP\", \"ES\", \"CH\", \"NL\", \"CN\", \"HK\", \"MX\", \"DK\", \"RO\", \"SK\", \"BG\", \"CZ\", \"FI\", \"HU\", \"LV\", \"LT\", \"MT\", \"EE\", \"GR\", \"PT\", \"CY\", \"SI\", \"SE\", \"KR\", \"ZA\", \"TH\", \"IE\", \"PL\", \"IL\", \"NZ\", \"SG\"], \"expeditedShipping\": [\"true\"], \"oneDayShippingAvailable\": [\"false\"], \"handlingTime\": [\"2\"] } ], \"sellingStatus\": [{\"currentPrice\": [{\"@currencyId\": \"USD\", \"__value__\": \"1150.0\"} ], \"convertedCurrentPrice\": [{\"@currencyId\": \"USD\", \"__value__\": \"1150.0\"} ], \"sellingState\": [\"Active\"], \"timeLeft\": [\"P6DT10H17M16S\"] } ], \"listingInfo\": [{\"bestOfferEnabled\": [\"true\"], \"buyItNowAvailable\": [\"false\"], \"startTime\": [\"2015-09-18T19:42:57.000Z\"], \"endTime\": [\"2015-09-25T19:42:57.000Z\"], \"listingType\": [\"StoreInventory\"], \"gift\": [\"false\"] } ], \"returnsAccepted\": [\"false\"], \"condition\": [{\"conditionId\": [\"1000\"], \"conditionDisplayName\": [\"New\"] } ], \"isMultiVariationListing\": [\"false\"], \"topRatedListing\": [\"false\"] } ] } ], \"paginationOutput\": [{\"pageNumber\": [\"1\"], \"entriesPerPage\": [\"1\"], \"totalPages\": [\"70805\"], \"totalEntries\": [\"70805\"] } ], \"itemSearchURL\": [\"http://rover.ebay.com/rover/1/711-53200-19255-0/1?ff3=4&toolid=10041&campid=5337737097&customid=&lgeo=1&mpre=http%3A%2F%2Fwww.ebay.com%2Fsch%2Fi.html%3F_nkw%3Diphone%2B6s%26_ddo%3D1%26_ipg%3D1%26_pgn%3D1\"] } ]";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonMock);
        FindingApiParserImpl findingApiParser = new FindingApiParserImpl();
        Response response = findingApiParser.parse(jsonNode);
        List<ParsedItem> items = response.getItems();
        for (ParsedItem item : items) {
            assertNotNull(item.getCountry());
            assertNotNull(item.getShippingInfo());
            assertEquals("handlingTime should be 2", "2", item.getShippingInfo().getHandlingTime().get(0));
        }
        assertEquals("pageNumber should be 1","1",response.getParsedPaginationOutput().getPageNumber());
        assertEquals("totalPages should be 70805","70805",response.getParsedPaginationOutput().getTotalPages());

    }
}