package co.com.bancolombia.model.paymentmethods.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PaymentMethodsRequest {
    private String customerId;
    private String productType;
    private String bin;
    private Long pageSize;
    private Long pageNumber;
    private String messageId;
}
