package co.com.bancolombia.apiconnect.deposit;

import co.com.bancolombia.logging.technical.LoggerFactory;
import co.com.bancolombia.logging.technical.logger.TechLogger;
import co.com.bancolombia.model.apiconnect.request.PricingCredentials;
import co.com.bancolombia.model.deposit.gateway.DepositGateway;
import co.com.bancolombia.model.deposit.request.TopGMFRequest;
import co.com.bancolombia.model.deposit.request.listplans.ListPlansRequest;
import co.com.bancolombia.model.deposit.response.listplans.ListPlansResponse;
import co.com.bancolombia.model.deposit.response.topgmf.TopGMFResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DepositApiClient implements DepositGateway {

    private final TechLogger techLogger = LoggerFactory.getLog(getClass().getName());

    private final WebClient webClient;
    private final String pathRtrvDtlTransactionTax;
    private final String pathAccountsOffers;

    @Override
    public Mono<TopGMFResponse> retrieveDetailsTransactionTax(String messageId, PricingCredentials pricingCredentials,
                                                              TopGMFRequest topGMFRequest) {
        return webClient.post()
            .uri(pathRtrvDtlTransactionTax)
            .headers(httpHeaders -> buildHeaders(httpHeaders, messageId, pricingCredentials))
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(topGMFRequest)
            .retrieve()
            .bodyToMono(TopGMFResponse.class);
    }

    @Override
    public Mono<ListPlansResponse> accountsOffers(String messageId, PricingCredentials pricingCredentials,
                                                  ListPlansRequest listPlansRequest) {
        return webClient.post()
            .uri(pathAccountsOffers)
            .headers(httpHeaders -> buildHeaders(httpHeaders, messageId, pricingCredentials))
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(listPlansRequest)
            .retrieve()
            .bodyToMono(ListPlansResponse.class);
    }

    private void buildHeaders(HttpHeaders httpHeaders, String messageId, PricingCredentials pricingCredentials) {
        httpHeaders.add(DepositApiPathName.DEPOSIT_HEADER_MESSAGE_ID, messageId);
        httpHeaders.add(DepositApiPathName.DEPOSIT_HEADER_CLIENT_ID, pricingCredentials.getClientId());
        httpHeaders.add(DepositApiPathName.DEPOSIT_HEADER_CLIENT_SECRET, pricingCredentials.getClientSecret());
        httpHeaders.add(DepositApiPathName.DEPOSIT_JASON_WEB_TOKEN, pricingCredentials.getJasonWebToken());
    }

}
