package co.com.bancolombia.apiconnect.paymentmethods;

import co.com.bancolombia.apiconnect.deposit.DepositApiPathName;
import co.com.bancolombia.logging.technical.LoggerFactory;
import co.com.bancolombia.logging.technical.logger.TechLogger;
import co.com.bancolombia.model.apiconnect.request.PricingCredentials;
import co.com.bancolombia.model.paymentmethods.gateway.PaymentMethodsGateway;
import co.com.bancolombia.model.paymentmethods.request.PaymentMethodsRequest;
import co.com.bancolombia.model.paymentmethods.request.debitcardcost.DebitCardCostRequest;
import co.com.bancolombia.model.paymentmethods.response.ActiveCards;
import co.com.bancolombia.model.paymentmethods.response.debitcardcost.DebitCardCostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PaymentMethodsApiClient implements PaymentMethodsGateway {

    private final TechLogger techLogger = LoggerFactory.getLog(PaymentMethodsApiClient.class.getName());

    private final WebClient webClient;
    private final String pathRtrvRetrieveActiveCards;
    private final String pathDebitCardCost;

    @Override
    public Mono<ActiveCards> retrieveActiveCards(String messageId,
                                                 PricingCredentials pricingCredentials,
                                                 PaymentMethodsRequest paymentMethodsRequest) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("customerId")
                        .queryParam("productType", paymentMethodsRequest.getProductType())
                        .queryParam("bin", paymentMethodsRequest.getBin())
                        .queryParam("pageSize", paymentMethodsRequest.getPageSize())
                        .queryParam("pageNumber", paymentMethodsRequest.getPageNumber())
                        .build())
                .headers(httpHeaders -> buildHeaders(httpHeaders, messageId, pricingCredentials))
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ActiveCards.class);
    }

    @Override
    public Mono<DebitCardCostResponse> invokeDebitCardCost(String messageId, PricingCredentials pricingCredentials,
                                                           DebitCardCostRequest debitCardCostRequest) {
        return webClient.post()
                .headers(httpHeaders -> buildHeaders(httpHeaders, messageId, pricingCredentials))
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(debitCardCostRequest)
                .retrieve()
                .bodyToMono(DebitCardCostResponse.class);
    }

    private void buildHeaders(HttpHeaders httpHeaders, String messageId,
                              PricingCredentials pricingCredentials) {
        httpHeaders.add(DepositApiPathName.DEPOSIT_HEADER_MESSAGE_ID, messageId);
        httpHeaders.add(DepositApiPathName.DEPOSIT_HEADER_CLIENT_ID, pricingCredentials.getClientId());
        httpHeaders.add(DepositApiPathName.DEPOSIT_HEADER_CLIENT_SECRET, pricingCredentials.getClientSecret());
    }

}
