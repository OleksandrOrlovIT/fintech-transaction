CREATE TYPE category AS ENUM ('FOOD', 'TRANSPORT', 'UNCATEGORIZED');

CREATE TABLE transactions (
                              id SERIAL PRIMARY KEY,
                              user_id VARCHAR(50),
                              amount DECIMAL(10, 2),
                              description TEXT,
                              timestamp TIMESTAMPTZ,
                              category category
);
