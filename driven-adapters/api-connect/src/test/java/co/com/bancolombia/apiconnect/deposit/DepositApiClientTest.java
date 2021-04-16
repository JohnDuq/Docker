package co.com.bancolombia.apiconnect.deposit;

import co.com.bancolombia.model.apiconnect.request.PricingCredentials;
import co.com.bancolombia.model.deposit.request.TopGMFRequest;
import co.com.bancolombia.model.deposit.response.topgmf.TopGMFData;
import co.com.bancolombia.model.deposit.response.topgmf.TopGMFResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.com.bancolombia.model.deposit.request.listplans.ListPlansRequest;
import co.com.bancolombia.model.deposit.request.listplans.Pagination;
import co.com.bancolombia.model.deposit.response.listplans.ListPlansResponse;
import co.com.bancolombia.model.deposit.response.listplans.Plan;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DepositApiClientTest {

    public static final String MESSAGE_ID = "MESSAGE_ID";
    public static final String TYPE_ACCOUNT = "TYPE_ACCOUNT";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ACCEPT = "Accept";
    public static final int FIRST_ELEMENT = 0;
    public static final String PATH = "/";

    private ObjectMapper objectMapper;
    private static MockWebServer mockWebServer;
    private DepositApiClient depositApiClient;

    @BeforeEach
    public void setup() throws IOException {
        this.objectMapper = new ObjectMapper();
        this.mockWebServer = new MockWebServer();
        this.mockWebServer.start();
        WebClient webClient = WebClient.create(mockWebServer.url(PATH).toString());
        this.depositApiClient = new DepositApiClient(webClient, PATH, PATH);
    }

    @AfterAll
    public static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void invokeTopGMFApiTest() throws JsonProcessingException {

        TopGMFResponse mockDebitCardCost = buildTopGMFResponse();

        MockResponse mockResponse = new MockResponse()
                .addHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .addHeader(ACCEPT, MediaType.APPLICATION_JSON)
                .setBody(topGMFResponseToString(mockDebitCardCost))
                .setResponseCode(200);

        mockWebServer.enqueue(mockResponse);
        TopGMFResponse response = depositApiClient.retrieveDetailsTransactionTax(MESSAGE_ID, new PricingCredentials(),
                new TopGMFRequest()).block();
        assert response != null;
        Assertions.assertEquals(TYPE_ACCOUNT, response.getData().get(FIRST_ELEMENT).getAccount().getType());
    }

    private TopGMFResponse buildTopGMFResponse() {
        co.com.bancolombia.model.deposit.response.topgmf.Account account = new co.com.bancolombia.model.deposit.response.topgmf.Account();
        account.setType("TYPE_ACCOUNT");
        TopGMFData topGMFData = new TopGMFData();
        topGMFData.setAccount(account);
        List<TopGMFData> topGMFDataList = new ArrayList<>();
        topGMFDataList.add(topGMFData);

        return TopGMFResponse
                .builder()
                .data(topGMFDataList)
                .build();
    }

    private String topGMFResponseToString(TopGMFResponse topGMFResponse) throws JsonProcessingException {
        return objectMapper.writeValueAsString(topGMFResponse);
    }

    @Test
    void invokeAccountOffersApiTest() throws JsonProcessingException {

        ListPlansResponse mockListPlans = buildListPlansResponse();

        MockResponse mockResponse = new MockResponse()
            .addHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .addHeader(ACCEPT, MediaType.APPLICATION_JSON)
            .setBody(listPlansToString(mockListPlans))
            .setResponseCode(200);

        mockWebServer.enqueue(mockResponse);
        ListPlansResponse response = depositApiClient.accountsOffers(MESSAGE_ID, new PricingCredentials(),
            new ListPlansRequest()).block();
        assert response != null;
        Assertions.assertEquals("Id", response.getPlan().getId());
    }

    private ListPlansResponse buildListPlansResponse() {

        Plan plan = new Plan();
        plan.setId("Id");
        plan.setDescription("Description");
        plan.setName("Name");
        plan.setStatementFrequency("Frequency");
        plan.setStatus("Status");

        return ListPlansResponse
            .builder()
            .plan(plan)
            .build();
    }

    private String listPlansToString(ListPlansResponse listPlansResponse) throws JsonProcessingException {
        return objectMapper.writeValueAsString(listPlansResponse);
    }
}
