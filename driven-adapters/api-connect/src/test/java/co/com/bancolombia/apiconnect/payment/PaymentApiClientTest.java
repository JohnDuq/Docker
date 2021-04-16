package co.com.bancolombia.apiconnect.payment;

import co.com.bancolombia.apiconnect.paymentmethods.PaymentMethodsApiClient;
import co.com.bancolombia.model.apiconnect.request.PricingCredentials;
import co.com.bancolombia.model.paymentmethods.request.PaymentMethodsRequest;
import co.com.bancolombia.model.paymentmethods.request.debitcardcost.DebitCardCostRequest;
import co.com.bancolombia.model.paymentmethods.response.ActiveCards;
import co.com.bancolombia.model.paymentmethods.response.CardType;
import co.com.bancolombia.model.paymentmethods.response.Cards;
import co.com.bancolombia.model.paymentmethods.response.PaymentMethodsData;
import co.com.bancolombia.model.paymentmethods.response.debitcardcost.DebitCardCostData;
import co.com.bancolombia.model.paymentmethods.response.debitcardcost.DebitCardCostResponse;
import co.com.bancolombia.model.paymentmethods.response.debitcardcost.ShareCost;
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

class PaymentApiClientTest {
    public static final String MESSAGE_ID = "MESSAGE_ID";
    public static final String CARP_TYPE_ID = "1";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ACCEPT = "Accept";
    public static final int FIRST_ELEMENT = 0;
    public static final String PATH = "/";

    private ObjectMapper objectMapper;
    private static MockWebServer mockWebServer;
    private PaymentMethodsApiClient paymentMethodsApiClient;

    @BeforeEach
    public void setup() throws IOException {
        this.objectMapper = new ObjectMapper();
        this.mockWebServer = new MockWebServer();
        this.mockWebServer.start();
        WebClient webClient = WebClient.create(mockWebServer.url("/").toString());
        this.paymentMethodsApiClient = new PaymentMethodsApiClient(webClient, PATH, PATH);
    }

    @AfterAll
    public static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void invokeDepositApi() throws JsonProcessingException {

        ActiveCards mockDepositResponse = buildPaymentMethodResponse();

        MockResponse mockResponse = new MockResponse()
                .addHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .addHeader(ACCEPT, MediaType.APPLICATION_JSON)
                .setBody(paymentMethodResponseToString(mockDepositResponse))
                .setResponseCode(200);

        mockWebServer.enqueue(mockResponse);
        ActiveCards response = paymentMethodsApiClient.retrieveActiveCards(MESSAGE_ID, new PricingCredentials(),
                new PaymentMethodsRequest()).block();
        assert response != null;
        Assertions.assertEquals(CARP_TYPE_ID, response.getData().get(FIRST_ELEMENT).getCardsList().get(0).getCardType().getId());
    }

    @Test
    void invokeDebitCardCost() throws JsonProcessingException {

        DebitCardCostResponse mockDebitCardCost = buildDebitCardCostResponse();

        MockResponse mockResponse = new MockResponse()
                .addHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .addHeader(ACCEPT, MediaType.APPLICATION_JSON)
                .setBody(debitCardCostResponseToString(mockDebitCardCost))
                .setResponseCode(200);

        mockWebServer.enqueue(mockResponse);
        DebitCardCostResponse response = paymentMethodsApiClient.invokeDebitCardCost(MESSAGE_ID, new PricingCredentials(),
                new DebitCardCostRequest()).block();
        assert response != null;
        Assertions.assertEquals(mockDebitCardCost.getData().getShareCost().getAmount(), response.getData().getShareCost().getAmount());
    }

    private ActiveCards buildPaymentMethodResponse() {
        CardType cardType = new CardType();
        cardType.setId("1");
        cardType.setDescription("Description");

        Cards cards = new Cards();
        cards.setCardType(cardType);

        List<Cards> cardsList = new ArrayList<>();
        cardsList.add(cards);


        PaymentMethodsData paymentMethodsData = new PaymentMethodsData();
        paymentMethodsData.setCardsList(cardsList);
        List<PaymentMethodsData> list = new ArrayList<>();
        list.add(paymentMethodsData);
        return ActiveCards
                .builder()
                .data(list)
                .build();
    }

    private DebitCardCostResponse buildDebitCardCostResponse() {
        ShareCost shareCost = new ShareCost();
        shareCost.setAmount(1L);

        DebitCardCostData debitCardCostData = new DebitCardCostData();
        debitCardCostData.setShareCost(shareCost);
        return DebitCardCostResponse
                .builder()
                .data(debitCardCostData)
                .build();
    }

    private String paymentMethodResponseToString(ActiveCards activeCards) throws JsonProcessingException {
        return objectMapper.writeValueAsString(activeCards);
    }

    private String debitCardCostResponseToString(DebitCardCostResponse debitCardCostResponse) throws JsonProcessingException {
        return objectMapper.writeValueAsString(debitCardCostResponse);
    }
}
