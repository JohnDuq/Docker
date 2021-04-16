package co.com.bancolombia.model.pricing.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiConnectNameEnum {

    API_CONNECT("0", "API_CONNECT"),
    DEPOSIT("1", "DEPOSIT"),
    PAYMENT_METHODS("2", "PAYMENT METHODS");

    private final String code;
    private final String name;

}
