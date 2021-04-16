package co.com.bancolombia.model.deposit.response.listplans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    private String id;
    private String name;
    private String description;
    private String status;
    private String statementFrequency;
}
