DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'category') THEN
CREATE TYPE category AS ENUM ('FOOD', 'TRANSPORT', 'UNCATEGORIZED');
END IF;
END$$;

CREATE TABLE IF NOT EXISTS transactions (
                                            id SERIAL PRIMARY KEY,
                                            user_id VARCHAR(50),
    amount DECIMAL(10, 2),
    description TEXT,
    timestamp TIMESTAMPTZ,
    category category
    );
