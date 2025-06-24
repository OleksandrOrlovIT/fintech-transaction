package ua.orlov.fintechtransaction.dao.impl;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.orlov.fintechtransaction.dao.TransactionRepository;
import ua.orlov.fintechtransaction.mapper.jdbc.TransactionRowMapper;
import ua.orlov.fintechtransaction.model.Transaction;
import ua.orlov.fintechtransaction.util.SqlLoader;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Repository
public class TransactionRepositoryJDBC implements TransactionRepository {

    private static final String CREATE_TRANSACTION = SqlLoader.load("insert_transaction.sql");
    private static final String GET_ALL_TRANSACTIONS = SqlLoader.load("select_all_transactions.sql");

    private final JdbcTemplate jdbcTemplate;
    private final TransactionRowMapper transactionRowMapper;

    @Override
    public Transaction save(Transaction transaction) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(CREATE_TRANSACTION, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, transaction.getUserId());
            ps.setBigDecimal(2, transaction.getAmount());
            ps.setString(3, transaction.getDescription());
            ps.setTimestamp(4, Timestamp.valueOf(transaction.getTimestamp().toLocalDateTime()));
            ps.setString(5, String.valueOf(transaction.getCategory()));
            return ps;
        }, keyHolder);

        Map<String, Object> keys = keyHolder.getKeys();
        if (keys != null && keys.containsKey("id")) {
            transaction.setId(((Number) keys.get("id")).longValue());
        }

        return transaction;
    }

    @Override
    public List<Transaction> findAll() {
        return jdbcTemplate.query(GET_ALL_TRANSACTIONS, transactionRowMapper);
    }
}


