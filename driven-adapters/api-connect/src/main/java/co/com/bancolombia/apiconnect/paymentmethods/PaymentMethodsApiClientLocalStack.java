package co.com.bancolombia.apiconnect.paymentmethods;

import co.com.bancolombia.model.apiconnect.request.PricingCredentials;
import co.com.bancolombia.model.paymentmethods.gateway.PaymentMethodsGateway;
import co.com.bancolombia.model.paymentmethods.request.PaymentMethodsRequest;
import co.com.bancolombia.model.paymentmethods.request.debitcardcost.DebitCardCostRequest;
import co.com.bancolombia.model.paymentmethods.response.ActiveCards;
import co.com.bancolombia.model.paymentmethods.response.debitcardcost.DebitCardCostResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PaymentMethodsApiClientLocalStack implements PaymentMethodsGateway {

    @Override
    public Mono<ActiveCards> retrieveActiveCards(String messageId,
                                                 PricingCredentials pricingCredentials,
                                                 PaymentMethodsRequest paymentMethodsRequest) {
        return Mono.just(ActiveCards.builder().build());
    }

    @Override
    public Mono<DebitCardCostResponse> invokeDebitCardCost(String messageId, PricingCredentials pricingCredentials,
                                                           DebitCardCostRequest debitCardCostRequest) {
        return Mono.just(DebitCardCostResponse.builder().build());
    }

}
