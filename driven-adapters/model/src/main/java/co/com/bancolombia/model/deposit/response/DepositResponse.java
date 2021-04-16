package co.com.bancolombia.model.deposit.response;

import co.com.bancolombia.model.apiconnect.response.Errors;
import co.com.bancolombia.model.apiconnect.response.Links;
import co.com.bancolombia.model.apiconnect.response.Meta;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepositResponse implements Serializable {
    private static final long serialVersionUID = -1709023830069460449L;
    private Meta meta;
    private List<DepositData> data;
    private Links links;
    private List<Errors> errors;
}
