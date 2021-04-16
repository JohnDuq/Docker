package co.com.bancolombia.model.usecase.response.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Identification implements Serializable  {
    
    private static final long serialVersionUID = 3269265111260398640L;
    private String type;
    private String number;
    private String name;

}
