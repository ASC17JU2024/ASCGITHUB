-- Generate Database name ladb
CREATE DATABASE ladb;

-- Use Database ladb
USE ladb;

-- Generate MySQL table
CREATE TABLE product (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    price DOUBLE,
    quantity INT
);

-- Insert a record into MySQL table
INSERT INTO product (id, name, price, quantity) VALUES ('1', 'Laptop', 999.99, 1);


-- Select all records from MySQL table
SELECT * FROM product;