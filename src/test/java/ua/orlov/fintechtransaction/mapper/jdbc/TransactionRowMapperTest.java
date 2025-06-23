package ua.orlov.fintechtransaction.mapper.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.orlov.fintechtransaction.model.Category;
import ua.orlov.fintechtransaction.model.Transaction;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionRowMapperTest {

    @Mock
    private ResultSet mockResultSet;

    private TransactionRowMapper transactionRowMapper;

    @BeforeEach
    void setUp() {
        transactionRowMapper = new TransactionRowMapper();
    }

    @Test
    void testMapRow() throws SQLException {
        Long expectedId = 1L;
        String expectedUserId = "user123";
        BigDecimal expectedAmount = new BigDecimal("100.50");
        String expectedDescription = "Groceries from local store";
        Timestamp sqlTimestamp = Timestamp.valueOf("2023-10-26 10:30:00.000");
        Timestamp expectedTimestamp = Timestamp.valueOf("2023-10-26 10:30:00.000");
        Category expectedCategory = Category.FOOD;

        when(mockResultSet.getLong("id")).thenReturn(expectedId);
        when(mockResultSet.getString("user_id")).thenReturn(expectedUserId);
        when(mockResultSet.getBigDecimal("amount")).thenReturn(expectedAmount);
        when(mockResultSet.getString("description")).thenReturn(expectedDescription);
        when(mockResultSet.getTimestamp("timestamp")).thenReturn(sqlTimestamp);
        when(mockResultSet.getObject("category", Category.class)).thenReturn(expectedCategory);

        Transaction actualTransaction = transactionRowMapper.mapRow(mockResultSet, 0);

        assertNotNull(actualTransaction, "The mapped transaction should not be null");
        assertEquals(expectedId, actualTransaction.getId(), "ID should match");
        assertEquals(expectedUserId, actualTransaction.getUserId(), "User ID should match");
        assertEquals(0, expectedAmount.compareTo(actualTransaction.getAmount()), "Amount should match"); // Use compareTo for BigDecimal
        assertEquals(expectedDescription, actualTransaction.getDescription(), "Description should match");
        assertEquals(expectedTimestamp, actualTransaction.getTimestamp(), "Timestamp should match (including offset)");
        assertEquals(expectedCategory, actualTransaction.getCategory(), "Category should match");

        // Optional: Verify that ResultSet methods were called as expected
        verify(mockResultSet).getLong("id");
        verify(mockResultSet).getString("user_id");
        verify(mockResultSet).getBigDecimal("amount");
        verify(mockResultSet).getString("description");
        verify(mockResultSet).getTimestamp("timestamp");
        verify(mockResultSet).getObject("category", Category.class);
        verifyNoMoreInteractions(mockResultSet);
    }

    @Test
    void testMapRowWithNullValues() throws SQLException {
        Long expectedId = 2L;
        String expectedUserId = "user456";
        BigDecimal expectedAmount = new BigDecimal("25.75");
        String expectedDescription = null;
        Timestamp sqlTimestamp = null;
        Category expectedCategory = Category.TRANSPORT;

        when(mockResultSet.getLong("id")).thenReturn(expectedId);
        when(mockResultSet.getString("user_id")).thenReturn(expectedUserId);
        when(mockResultSet.getBigDecimal("amount")).thenReturn(expectedAmount);
        when(mockResultSet.getString("description")).thenReturn(expectedDescription);
        when(mockResultSet.getTimestamp("timestamp")).thenReturn(sqlTimestamp);
        when(mockResultSet.getObject("category", Category.class)).thenReturn(expectedCategory);

        Transaction actualTransaction = transactionRowMapper.mapRow(mockResultSet, 0);

        assertNotNull(actualTransaction, "The mapped transaction should not be null");
        assertEquals(expectedId, actualTransaction.getId(), "ID should match");
        assertEquals(expectedUserId, actualTransaction.getUserId(), "User ID should match");
        assertEquals(0, expectedAmount.compareTo(actualTransaction.getAmount()), "Amount should match");
        assertNull(actualTransaction.getDescription(), "Description should be null");
        assertNull(actualTransaction.getTimestamp(), "Timestamp should be null");
        assertEquals(expectedCategory, actualTransaction.getCategory(), "Category should match");

        verify(mockResultSet).getLong("id");
        verify(mockResultSet).getString("user_id");
        verify(mockResultSet).getBigDecimal("amount");
        verify(mockResultSet).getString("description");
        verify(mockResultSet).getTimestamp("timestamp");
        verify(mockResultSet).getObject("category", Category.class);
        verifyNoMoreInteractions(mockResultSet);
    }
}
