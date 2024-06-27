

USE SAKILA;
-- Step 1: Create a dummy product table
CREATE TABLE product (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(255),
    price DECIMAL(10, 2)
);

-- Step 2: Insert a couple of values into the product table
INSERT INTO product (product_id, product_name, price) VALUES (1, 'Laptop', 1200.00);
INSERT INTO product (product_id, product_name, price) VALUES (2, 'Smartphone', 800.00);
INSERT INTO product (product_id, product_name, price) VALUES (3, 'Tablet', 600.00);

-- Step 3: Demonstrate SELECT statement
SELECT * FROM product;
ROLLBACK;
-- Step 4: Demonstrate DELETE statement (without WHERE clause, it deletes all rows)
DELETE FROM product WHERE product_id = 3;

-- Step 5: Demonstrate TRUNCATE statement (removes all rows from the table)
TRUNCATE TABLE product;

-- Step 6: Demonstrate DROP statement (removes the table from the database)
DROP TABLE product;

-- Note: Rollback statement is used to undo transactions that have not yet been committed. 
-- It must be used within a transaction block.
USE TESTDB;
CREATE TABLE customer (a INT, b CHAR (20), INDEX (a));
-- Do a transaction with autocommit turned on.
START TRANSACTION;
INSERT INTO customer VALUES (10, 'Heikki');
SELECT * FROM CUSTOMER;
COMMIT;
-- Do another transaction with autocommit turned off.
SET autocommit=0;
INSERT INTO customer VALUES (15, 'John');

INSERT INTO customer VALUES (20, 'Paul');

DELETE FROM customer WHERE b = 'Heikki';

-- Now we undo those last 2 inserts and the delete.
ROLLBACK;

-- Enable autocommit mode
SET autocommit = 1;
DELETE FROM CUSTOMER;
-- Start a new transaction (autocommit mode will commit each statement automatically)
START TRANSACTION;
INSERT INTO customer VALUES (25, 'Alice');
-- This insert is automatically committed due to autocommit mode

-- Insert another record
INSERT INTO customer VALUES (30, 'Bob');
-- This insert is also automatically committed
COMMIT;
ROLLBACK;
SELECT * FROM CUSTOMER;
-- To demonstrate rollback, we'll disable autocommit, make changes, and then rollback
SET autocommit = 0;
START TRANSACTION;
INSERT INTO customer VALUES (35, 'Charlie');
DELETE FROM customer WHERE B = 'Alice';

-- Rollback the transaction (undo the insert and delete)
ROLLBACK;

-- Re-enable autocommit mode
SET autocommit = 1;
