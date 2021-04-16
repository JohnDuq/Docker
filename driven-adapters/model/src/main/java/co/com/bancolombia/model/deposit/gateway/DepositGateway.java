package co.com.bancolombia.model.deposit.gateway;

import co.com.bancolombia.model.apiconnect.request.PricingCredentials;
import co.com.bancolombia.model.deposit.request.TopGMFRequest;
import co.com.bancolombia.model.deposit.request.listplans.ListPlansRequest;
import co.com.bancolombia.model.deposit.response.listplans.ListPlansResponse;
import co.com.bancolombia.model.deposit.response.topgmf.TopGMFResponse;
import reactor.core.publisher.Mono;

public interface DepositGateway {

    Mono<TopGMFResponse> retrieveDetailsTransactionTax(String messageId, PricingCredentials pricingCredentials,
                                                       TopGMFRequest topGMFRequest);

    Mono<ListPlansResponse> accountsOffers(String messageId, PricingCredentials pricingCredentials,
                                           ListPlansRequest listPlansRequest);

}
