package co.com.bancolombia.model.apiconnect.response;

import co.com.bancolombia.model.deposit.response.topgmf.TopGMFResponse;
import co.com.bancolombia.model.paymentmethods.response.ActiveCards;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiConnectResponse implements Serializable {
    private static final long serialVersionUID = 3627654291386290021L;
    private TopGMFResponse topGMFResponse;
    private ActiveCards activeCards;
}
