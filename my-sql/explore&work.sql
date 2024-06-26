-- Retrieves the first name and last name of all actors. Useful for simple listings where detailed information isn't required.
SELECT first_name, last_name FROM actor;

-- Retrieves all columns for all actors. Useful when you need comprehensive information about each actor.
SELECT * FROM ACTOR;

-- Retrieves all columns for actors with the first name 'Penelope'. Filters actors by a specific first name.
SELECT * FROM ACTOR WHERE FIRST_NAME = 'PENELOPE';

-- Retrieves all columns for actors with the first name 'Penelope' or 'Nick'. Expands the filter to include actors with either of two specific first names.
SELECT * FROM ACTOR WHERE FIRST_NAME = 'PENELOPE' OR FIRST_NAME = 'NICK';

-- Attempts to retrieve actors with the first name 'Penelope' AND 'Nick', which is logically incorrect as a person cannot have two first names simultaneously.
SELECT * FROM ACTOR WHERE FIRST_NAME = 'PENELOPE' AND FIRST_NAME = 'NICK';

-- Attempts to retrieve actors with the first name 'Woody' AND last name 'Jolie'. Filters actors by both first and last name.
SELECT * FROM ACTOR WHERE FIRST_NAME = 'WOODY' AND last_name = 'JOLIE';

-- Retrieves actors with the first name 'Woody' OR last name 'Jolie'. Expands the filter to include actors with either a specific first name or last name.
SELECT * FROM ACTOR WHERE FIRST_NAME = 'WOODY' OR last_name = 'JOLIE';

-- Retrieves actors with first names 'Woody', 'Julia', or 'Penelope'. Uses the IN operator for a cleaner syntax when filtering by multiple specific values.
SELECT * FROM ACTOR WHERE FIRST_NAME IN ('WOODY', 'JULIA', 'PENELOPE');

-- Similar to the previous query but uses OR conditions to achieve the same result. Demonstrates an alternative to using IN.
SELECT * FROM actor WHERE first_name = 'Woody' OR first_name = 'Julia' OR first_name = 'Penelope';

-- Retrieves actors named 'Woody', 'Julia', or 'Penelope', ordered by first name in ascending order. Adds sorting to organize the output.
SELECT * FROM actor WHERE first_name = 'Woody' OR first_name = 'Julia' OR first_name = 'Penelope' ORDER BY first_name;

-- Similar to the previous query but orders the results by first name in descending order. Changes the order in which results are displayed.
SELECT * FROM actor WHERE first_name = 'Woody' OR first_name = 'Julia' OR first_name = 'Penelope' ORDER BY first_name DESC;

-- Retrieves the last 5 actors by ID who are named 'Woody', 'Julia', or 'Penelope'. Limits the result set to 5 for pagination or top-N queries.
SELECT * FROM actor WHERE first_name = 'Woody' OR first_name = 'Julia' OR first_name = 'Penelope' ORDER BY ACTOR_ID DESC LIMIT 5;

-- Skips the first 3 actors from the previous query and retrieves the next 5. Useful for paginating through results.
SELECT * FROM actor WHERE first_name = 'Woody' OR first_name = 'Julia' OR first_name = 'Penelope' ORDER BY ACTOR_ID DESC LIMIT 5 OFFSET 3;

-- Creates a table named order_items with columns for item ID, name, category, and quantity ordered. Defines the structure for storing order item data.
CREATE TABLE order_items (
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(255),
    category VARCHAR(255),
    quantity_ordered INT
);

-- Inserts sample data into the order_items table. Provides a set of initial data for testing or demonstration purposes.
INSERT INTO order_items (item_name, category, quantity_ordered) VALUES
('Laptop', 'Electronics', 2),
('Smartphone', 'Electronics', 5),
('T-Shirt', 'Apparel', 10),
('Jeans', 'Apparel', 4),
('Bluetooth Speaker', 'Electronics', 3),
('Sneakers', 'Apparel', 6),
('Keyboard', 'Electronics', 2),
('Mouse', 'Electronics', 4);

-- Retrieves all columns from the order_items table. Useful for viewing the entire dataset or for debugging.
SELECT * FROM order_items;

-- Calculates the total quantity ordered across all items. Useful for inventory or sales analysis.
SELECT SUM(quantity_ordered) FROM order_items;

-- Attempts to select quantity_ordered grouped by category, which might not work as expected without an aggregate function. Demonstrates a common mistake.
SELECT quantity_ordered FROM order_items GROUP BY category;

-- Retrieves the sum of quantity ordered for each category. Useful for analyzing sales or inventory by category.
SELECT category, SUM(quantity_ordered) FROM order_items GROUP BY category;

-- Same as above but results are ordered by category in ascending order. Adds sorting to organize the output by category.
SELECT category, SUM(quantity_ordered) FROM order_items GROUP BY category ORDER BY category;

-- Same as above but results are ordered by category in descending order. Changes the order in which categories are displayed.
SELECT category, SUM(quantity_ordered) FROM order_items GROUP BY category ORDER BY category DESC;

-- Retrieves the category with the highest sum of quantity ordered. Useful for identifying top-selling or most popular categories.
SELECT category, SUM(quantity_ordered) FROM order_items GROUP BY category ORDER BY category DESC LIMIT 1;

-- Skips the category with the highest sum and retrieves the next one. Useful for ranking categories by sales or inventory.
SELECT category, SUM(quantity_ordered) FROM order_items GROUP BY category ORDER BY category DESC LIMIT 1 OFFSET 1;

-- Retrieves categories where the total quantity ordered is greater than 18, ordered by category in descending order. Filters and ranks categories based on a specific condition.
SELECT category, SUM(quantity_ordered) AS total_quantity_ordered
FROM order_items
GROUP BY category
HAVING SUM(quantity_ordered) > 18
ORDER BY category DESC;

SELECT * FROM actor WHERE first_name = 'Mike' AND last_name = 'Hillyer';
SELECT category, SUM(quantity_ordered) FROM order_items GROUP BY category ORDER BY category DESC LIMIT 1 OFFSET 1;

-- Retrieves categories where the total quantity ordered is greater than 18, ordered by category in descending order. Filters and ranks categories based on a specific condition.
SELECT category, SUM(quantity_ordered) AS total_quantity_ordered
FROM order_items
GROUP BY category
HAVING SUM(quantity_ordered) > 18
ORDER BY category DESC;

SELECT * FROM actor WHERE first_name = 'Mike' AND last_name = 'Hillyer';
SELECT film_id FROM film WHERE title = 'Academy Dinosaur';
SELECT inventory_id FROM inventory WHERE film_id = 1 AND store_id = 1;
SELECT customer_id FROM customer WHERE first_name = 'Mary' AND last_name = 'Smith';
SELECT staff_id FROM staff WHERE first_name = 'Mike' AND last_name = 'Hillyer';
SELECT * FROM STAFF;

INSERT INTO rental (rental_date, inventory_id, customer_id, staff_id, return_date, last_update)
VALUES (NOW(), 2, 3, 4, NULL, NOW());