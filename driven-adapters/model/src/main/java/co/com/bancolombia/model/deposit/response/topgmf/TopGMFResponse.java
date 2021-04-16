package co.com.bancolombia.model.deposit.response.topgmf;

import co.com.bancolombia.model.apiconnect.response.Errors;
import co.com.bancolombia.model.apiconnect.response.Meta;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TopGMFResponse {
    private Meta meta;
    private List<TopGMFData> data;
    private List<Errors> errors;
}
