1. Which actors have the first name 'Scarlett'
select * from actor where first_name = 'Scarlett';

2. Which actors have the last name 'Johansson'
select * from actor where last_name like 'Johansson';

3. How many distinct actors last names are there?
select count(distinct last_name) from actor;

4. Which last names are not repeated?
select last_name from actor group by last_name having count(*) = 1;

5. Which last names appear more than once?
select last_name from actor group by last_name having count(*) > 1;

6. Which actor has appeared in the most films?
select actor.actor_id, actor.first_name, actor.last_name,
count(actor_id) as film_count
from actor join film_actor using (actor_id)
group by actor_id
order by film_count desc
limit 1;

7. Is 'Academy Dinosaur' available for rent from Store 1?
select film.film_id, film.title, store.store_id, inventory.inventory_id
from inventory join store using (store_id) join film using (film_id)
where film.title = 'Academy Dinosaur' and store.store_id = 1;

8. Which copies of films are at Store 1?
select film.film_id, film.title, store.store_id, inventory.inventory_id
from inventory join store using (store_id) join film using (film_id)
where film.title = 'Academy Dinosaur' and store.store_id = 1;

9. Insert a record to represent Mary Smith renting 'Academy Dinosaur' from Mike Hillyer at Store 1 today.
insert into rental (rental_date, inventory_id, customer_id, staff_id)
values (NOW(), 1, 1, 1);

10. Find the last or most recent rental?
select rental_id from rental order by rental_id desc limit 1;

11. What is that average length of all the films in the sakila DB?
select avg(length) from film;

12. What is the average length of films by category?
select category.name, avg(length)
from film join film_category using (film_id) join category using (category_id)
group by category.name
order by avg(length) desc;

13. Which film categories are longer than the average length of all the films?
select category.name, avg(length)
from film join film_category using (film_id) join category using (category_id)
group by category.name
having avg(length) > (select avg(length) from film)
order by avg(length) desc;