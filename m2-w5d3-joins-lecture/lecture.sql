-- ********* INNER JOIN ***********

-- Let's find out who made payment 16666:
SELECT * FROM payment WHERE payment_id = '16666';

-- Ok, that gives us a customer_id, but not the name. We can use the customer_id to get the name FROM the customer table
SELECT * FROM payment AS p
JOIN customer AS c ON p.customer_id = c.customer_id
WHERE payment_id = '16666';

-- We can see that the * pulls back everything from both tables. We just want everything from payment and then the first and last name of the customer:

SELECT p.*, c.first_name, c.last_name FROM payment AS p
JOIN customer AS c ON p.customer_id = c.customer_id
WHERE payment_id = '16666';

-- But when did they return the rental? Where would that data come from? From the rental table, so let’s join that.

SELECT p.*, c.first_name, c.last_name, r.return_date FROM payment AS p
JOIN customer AS c ON p.customer_id = c.customer_id
JOIN rental AS r ON r.rental_id = p.rental_id
WHERE payment_id = '16666';


-- What did they rent? Film id can be gotten through inventory.

SELECT p.*, c.first_name, c.last_name, r.return_date, f.title FROM payment AS p
JOIN customer AS c ON p.customer_id = c.customer_id
JOIN rental AS r ON r.rental_id = p.rental_id
JOIN inventory AS i ON i.inventory_id = r.inventory_id
JOIN film f ON f.film_id = i.film_id
WHERE payment_id = '16666';

-- What if we wanted to know who acted in that film?    

SELECT p.*, c.first_name, c.last_name, r.return_date, f.title, a.first_name, a.last_name FROM payment AS p
JOIN customer AS c ON p.customer_id = c.customer_id
JOIN rental AS r ON r.rental_id = p.rental_id
JOIN inventory AS i ON i.inventory_id = r.inventory_id
JOIN film f ON f.film_id = i.film_id
JOIN film_actor fa ON fa.film_id = f.film_id
JOIN actor a ON a.actor_id = fa.actor_id
WHERE payment_id = '16666';

-- What if we wanted a list of all the films and their categories ordered by film title

SELECT f.title, c.name  FROM film AS f
JOIN film_category AS fc ON fc.film_id = f.film_id
JOIN category AS c ON c.category_id = fc.category_id
ORDER BY f.title;
-- Show all the 'Comedy' films ordered by film title

SELECT f.title, c.name  FROM film AS f 
JOIN film_category AS fc ON fc.film_id = f.film_id
JOIN category AS c ON c.category_id = fc.category_id
WHERE c.name = 'Comedy'
ORDER BY f.title;

-- Finally, let's count the number of films under each category

SELECT name, COUNT(*)
FROM category
JOIN film_category ON category.category_id = film_category.category_id
GROUP BY category.category_id;


-- ********* LEFT JOIN ***********

-- (There aren't any great examples of left joins in the "dvdstore" database, so the following queries are for the "world" database)

-- A Left join, selects all records from the "left" table and matches them with records from the "right" table if a matching record exists. 

-- Let's display a list of all countries and their capitals, if they have some.

SELECT c.name, ci.name
FROM country c
LEFT JOIN city ci ON c.capital = ci.id;

-- Only 232 rows
-- But we’re missing entries:

SELECT COUNT(*) from country;

-- There are 239 countries. So how do we show them all even if they don’t have a capital?
-- That’s because if the rows don’t exist in both tables, we won’t show any information for it. If we want to show data FROM the left side table everytime, we can use a different join:

-- *********** UNION *************

-- Back to the "dvdstore" database...

-- Gathers a list of all first names used by actors and customers
-- By default removes duplicates

SELECT first_name FROM actor
UNION 
SELECT first_name FROM customer;

-- Gather the list, but this time note the source table with 'A' for actor and 'C' for customer

SELECT first_name, 'A' FROM actor
UNION 
SELECT first_name, 'C' FROM customer;