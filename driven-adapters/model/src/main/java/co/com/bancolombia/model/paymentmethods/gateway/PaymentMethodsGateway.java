package co.com.bancolombia.model.paymentmethods.gateway;

import co.com.bancolombia.model.apiconnect.request.PricingCredentials;
import co.com.bancolombia.model.paymentmethods.request.PaymentMethodsRequest;
import co.com.bancolombia.model.paymentmethods.request.debitcardcost.DebitCardCostRequest;
import co.com.bancolombia.model.paymentmethods.response.ActiveCards;
import co.com.bancolombia.model.paymentmethods.response.debitcardcost.DebitCardCostResponse;
import reactor.core.publisher.Mono;

public interface PaymentMethodsGateway {

    Mono<ActiveCards> retrieveActiveCards(String messageId,
                                          PricingCredentials pricingCredentials,
                                          PaymentMethodsRequest paymentMethodsRequest);

    Mono<DebitCardCostResponse> invokeDebitCardCost(String messageId,
                                                    PricingCredentials pricingCredentials,
                                                    DebitCardCostRequest debitCardCostRequest);
}
