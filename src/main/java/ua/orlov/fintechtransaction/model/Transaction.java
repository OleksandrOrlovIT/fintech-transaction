package ua.orlov.fintechtransaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private Long id;

    private String userId;

    private BigDecimal amount;

    private String description;

    private Timestamp timestamp;

    private Category category;
}
