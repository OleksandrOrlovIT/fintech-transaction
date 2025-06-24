package ua.orlov.fintechtransaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("transactions")
public class Transaction {

    @Id
    private Long id;

    private String userId;

    private BigDecimal amount;

    private String description;

    private OffsetDateTime timestamp;

    private Category category;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", category=" + category +
                '}';
    }
}
