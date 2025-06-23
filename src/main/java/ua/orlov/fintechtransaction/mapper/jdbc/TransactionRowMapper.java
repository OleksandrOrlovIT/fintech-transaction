package ua.orlov.fintechtransaction.mapper.jdbc;

import org.springframework.jdbc.core.RowMapper;
import ua.orlov.fintechtransaction.model.Category;
import ua.orlov.fintechtransaction.model.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRowMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getLong("id"));
        transaction.setUserId(rs.getString("user_id"));
        transaction.setAmount(rs.getBigDecimal("amount"));
        transaction.setDescription(rs.getString("description"));
        transaction.setTimestamp(rs.getTimestamp("timestamp"));
        transaction.setCategory(rs.getObject("category", Category.class));

        return transaction;
    }
}
