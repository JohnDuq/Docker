package co.com.bancolombia.model.apiconnect.response;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Errors implements Serializable {
    private static final long serialVersionUID = -815426911457153156L;
    private String id;
    private String href;
    private Integer status;
    private String code;
    private String title;
    private String detail;
}
