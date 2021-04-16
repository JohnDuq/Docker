
package co.com.bancolombia.model.dynamodb.response.localstack;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

    private static final long serialVersionUID = 125934579717337709L;

    private String idDetail;
    private String subtitle;
    private String tag;
    private String paragraph;
    private String icon;
    private List<String> items;
    private Charge charge;
    private String benefit;

}
