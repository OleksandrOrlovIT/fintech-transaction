INSERT INTO transactions (user_id, amount, description, timestamp, category)
VALUES (?, ?, ?, ?, ?)
RETURNING *;
