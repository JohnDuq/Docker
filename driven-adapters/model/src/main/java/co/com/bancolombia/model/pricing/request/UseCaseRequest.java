package co.com.bancolombia.model.pricing.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
@Getter
@ToString
public class UseCaseRequest implements Serializable {
    private static final long serialVersionUID = 9161877553391299328L;
    private String messageId;
    private String typeAccount;
    private String numberAccount;
}
