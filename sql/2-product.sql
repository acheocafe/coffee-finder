-- Drop the table if it already exists
DROP TABLE IF EXISTS product;

CREATE TABLE product(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(5, 2) NOT NULL,
    merchant_id INT,
    FOREIGN KEY (merchant_id) REFERENCES merchant(id)
);
