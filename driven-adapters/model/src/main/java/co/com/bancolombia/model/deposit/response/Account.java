package co.com.bancolombia.model.deposit.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = -8105493768964710700L;
    private String name;
    private String currency;
    private Integer inactiveDays;
    private String openingDate;
    private String closingDate;
    private Boolean jointHolder;
    private Integer overdraftDays;
    private Integer overdueDays;
    private Integer daysTerm;
    private Regime regime;
    private Boolean allowDebit;
    private Boolean allowCredit;
    private Boolean isClosed;
    private Office office;
    private List<Specification> specifications;
    private Customer customer;
}
