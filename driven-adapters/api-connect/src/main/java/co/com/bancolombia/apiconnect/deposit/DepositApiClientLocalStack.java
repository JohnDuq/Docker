package co.com.bancolombia.apiconnect.deposit;

import co.com.bancolombia.model.apiconnect.request.PricingCredentials;
import co.com.bancolombia.model.deposit.gateway.DepositGateway;
import co.com.bancolombia.model.deposit.request.TopGMFRequest;
import co.com.bancolombia.model.deposit.request.listplans.ListPlansRequest;
import co.com.bancolombia.model.deposit.response.listplans.ListPlansResponse;
import co.com.bancolombia.model.deposit.response.topgmf.TopGMFResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DepositApiClientLocalStack implements DepositGateway {

    @Override
    public Mono<TopGMFResponse> retrieveDetailsTransactionTax(String messageId, PricingCredentials pricingCredentials,
                                                              TopGMFRequest topGMFRequest) {
        return Mono.just(TopGMFResponse.builder().build());
    }

    @Override
    public Mono<ListPlansResponse> accountsOffers(String messageId, PricingCredentials pricingCredentials, ListPlansRequest listPlansRequest) {
        return Mono.just(ListPlansResponse.builder().build());
    }

}
