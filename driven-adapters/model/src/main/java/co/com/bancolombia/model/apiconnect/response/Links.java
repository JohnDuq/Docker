package co.com.bancolombia.model.apiconnect.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Links implements Serializable {
    private static final long serialVersionUID = -6617863964729664790L;
    private String self;
}
