package ua.orlov.fintechtransaction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionRequest {

    private String userId;

    private BigDecimal amount;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", shape = JsonFormat.Shape.STRING)
    private OffsetDateTime timestamp;

    private String category;

}
