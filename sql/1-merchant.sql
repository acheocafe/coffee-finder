DROP TABLE IF EXISTS merchant;

CREATE TABLE merchant(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20),
    email VARCHAR(100),
    website VARCHAR(255),
    location_id INT,
    FOREIGN KEY (location_id) REFERENCES location(id)
);
