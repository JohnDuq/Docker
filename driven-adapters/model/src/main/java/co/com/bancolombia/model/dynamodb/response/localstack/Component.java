
package co.com.bancolombia.model.dynamodb.response.localstack;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Component implements Serializable {
    private static final long serialVersionUID = 3765417401474364801L;
    private String tittle;
    private String description;
    private List<Member> members;
}
