DROP TABLE IF EXISTS exchange_rate;

CREATE TABLE IF NOT EXISTS exchange_rate
(id INT NOT NULL AUTO_INCREMENT,
    source VARCHAR(255),
    target VARCHAR(255),
    rate DECIMAL(10, 2),
    amount DECIMAL(10, 2),
    converted DECIMAL(10, 2),
    PRIMARY KEY (id));