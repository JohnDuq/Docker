
package co.com.bancolombia.model.dynamodb.response.localstack;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Tab implements Serializable {
    private static final long serialVersionUID = -2672164400591215497L;
    private String pantalla;
    private List<Component> components;
}
