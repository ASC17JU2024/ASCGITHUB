-- Active: 1719376045923@@127.0.0.1@3306@sakila
-- JOINS -- 
CREATE DATABASE TESTDB;
USE TESTDB;
USE SAKILA;
SELECT * FROM ACTOR;

CREATE TABLE TABLE1( ID INT, VALUE VARCHAR(10));

-- UNION
-- SELECT 1 AS 'NUMBER', 'RED' AS 'COLOR'
SELECT 1 , 'RED'
UNION 
SELECT 2, 'GREEN'
UNION
SELECT 3, 'RED';

-- INSERT VALUES INT TABLE1
INSERT INTO TABLE1 VALUES(1, 'RED');
SELECT * FROM TABLE1;
DELETE FROM TABLE1;

INSERT INTO TABLE1 (ID, VALUE)
SELECT 1 , 'RED' 
UNION 
SELECT 2, 'GREEN'
UNION
SELECT 3, 'BLUE';

CREATE TABLE TABLE2( ID INT, VALUE VARCHAR(10));
INSERT INTO TABLE2 (ID, VALUE)
SELECT 2 , 'BASKET' 
UNION 
SELECT 3, 'BASE'
UNION
SELECT 6, 'CRICKET'
UNION
SELECT 7, 'FOOT';
SELECT * FROM TABLE2;

SELECT * FROM TABLE1
UNION
SELECT * FROM TABLE2;

-- CROSS JOIN
SELECT * FROM TABLE1
CROSS JOIN TABLE2;

-- INNER JOIN
SELECT * FROM TABLE1
INNER JOIN TABLE2
ON TABLE1.ID = TABLE2.ID;

-- SOLVING AMBUGUITY
SELECT TABLE1.ID,TABLE1.VALUE FROM TABLE1 
INNER JOIN TABLE2
ON TABLE1.ID = TABLE2.ID;

SELECT T1.ID,T1.VALUE FROM TABLE1 T1
INNER JOIN TABLE2 T2
ON T1.ID = T2.ID;
-- THE INNER KEYWORD IS OPTIONAL
SELECT * FROM TABLE1
 JOIN TABLE2
ON TABLE1.ID = TABLE2.ID;

-- LEFT OUTER JOIN
SELECT * FROM TABLE1
LEFT JOIN TABLE2
ON TABLE1.ID = TABLE2.ID;

SELECT * FROM TABLE1
LEFT OUTER JOIN TABLE2
ON TABLE1.ID = TABLE2.ID;

-- RIGHT OUTER JOIN
SELECT  * FROM TABLE1
RIGHT OUTER JOIN TABLE2
ON TABLE1.ID = TABLE2.ID;

SELECT  * FROM TABLE1
RIGHT JOIN TABLE2
ON TABLE1.ID = TABLE2.ID;

-- USING TABLE ALIAS
SELECT  * FROM TABLE1 LT
RIGHT OUTER JOIN TABLE2 RT
ON LT.ID = RT.ID;



-- IP
-- FULL OTUER JOIN
-- MATCHING RECORDS (LEFT TABLE + RIGTH TABLE), ALL RECORDS FROM THE LEFT AND RIGHT TABLES.
-- THE RESULT OF INNER JOIN, LEFT OUTER JOIN AND RIGHT OUTER JOIN. 
-- TRY OTHER WAYS TO CREATE JOINS


---------------------------------------------------
-- ANSI SQL (American National Standards Institute Structured Query Language) is a standard language for managing and manipulating databases. It provides a standardized syntax for tasks such as querying data, updating databases, and managing database objects. ANSI SQL aims to ensure interoperability across different database systems, allowing SQL code to be portable across various database management systems (DBMS) with minimal changes. The standard covers a wide range of operations, including data query, data manipulation (INSERT, UPDATE, DELETE), data definition (CREATE, ALTER, DROP), and data access control.
--ANSI SQL
-- INNER JOIN: Selects records that have matching values in both tables.
SELECT * FROM table1
INNER JOIN table2
ON table1.ID = table2.ID;

-- LEFT OUTER JOIN (or simply LEFT JOIN): Selects all records from the left table, and the matched records from the right table. The result is NULL from the right side, if there is no match.
SELECT * FROM table1
LEFT OUTER JOIN table2
ON table1.ID = table2.ID;

-- RIGHT OUTER JOIN (or simply RIGHT JOIN): Selects all records from the right table, and the matched records from the left table. The result is NULL from the left side, if there is no match.
SELECT * FROM table1
RIGHT OUTER JOIN table2
ON table1.ID = table2.ID;

-- FULL OUTER JOIN: Selects all records when there is a match in either left or right table.
SELECT * FROM table1
FULL OUTER JOIN table2
ON table1.ID = table2.ID;


SELECT * FROM table1
LEFT OUTER JOIN table2
ON table1.ID = table2.ID
UNION
SELECT * FROM table1
RIGHT OUTER JOIN table2
ON table1.ID = table2.ID;

-- CROSS JOIN: Returns a Cartesian product of the two tables, i.e., it will return rows combining each row from the first table with each row from the second table.
SELECT * FROM table1
CROSS JOIN table2;

