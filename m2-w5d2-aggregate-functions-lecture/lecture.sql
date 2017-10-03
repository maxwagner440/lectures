-- LIKE
SELECT * FROM country WHERE continent LIKE '%S%A%';

-- ORDERING RESULTS

-- Populations of all countries in descending order
SELECT name FROM country ORDER BY population;

--Names of countries and continents in ascending order
SELECT name, continent FROM country ORDER BY continent ASC, name ASC;


-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
SELECT name, lifeexpectancy FROM country WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC LIMIT 10 OFFSET 10; 

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington. 
-- "city, state", sorted by state then city
SELECT name || ',' || district FROM city WHERE district IN ('California', 'Oregon', 'Washington');
--OR
SELECT CONCAT(name, ', ', district) AS city_state FROM city WHERE district IN ('California', 'Oregon', 'Washington')
ORDER BY city_state;

SELECT name, ABS(indepyear) AS absolute_year FROM country WHERE indepyear IS NOT NULL ORDER BY indepyear ASC;

-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World
SELECT AVG(lifeexpectancy) FROM country WHERE lifeexpectancy IS NOT NULL;

-- Total population in Ohio
SELECT SUM(population) FROM city WHERE district = 'Ohio';

-- The surface area of the smallest country in the world

-- surfacearea = () is how we select what ever country has the smallest surface area.
SELECT name, surfacearea FROM country WHERE surfacearea = (SELECT MIN(surfacearea) FROM country);

-- The 10 largest countries in the world
SELECT * FROM country ORDER BY surfacearea DESC LIMIT 10;

-- The number of countries who declared independence in 1991
SELECT count(name) FROM country WHERE indepyear = '1991';

-- GROUP BY EXERCISES
-- Count the number of countries where each language is spoken, order show them from most countries to least

SELECT COUNT(countrycode) AS countries_spoken, language FROM countrylanguage 
GROUP BY language
ORDER BY countries_spoken DESC;

-- Average life expectancy of each continent ordered from highest to lowest

SELECT continent, AVG(lifeexpectancy) AS avg_life_expect FROM country
GROUP BY continent
ORDER BY avg_life_expect DESC;

-- Exclude Antarctica from consideration for average life expectancy

SELECT continent, AVG(lifeexpectancy) AS avg_life_expect FROM country 
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY avg_life_expect DESC;

-- Sum of the population of cities in each state in the USA ordered by state name

SELECT district, SUM(population) FROM city WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district ASC;

-- The average population of cities in each state in the USA ordered by state name

SELECT district, AVG(population) AS avg_pop FROM city WHERE countrycode = 'USA' 
GROUP BY district 
ORDER BY district ASC;

-- Additional samples
-- You may alias column and table names to provide more descriptive names
--SELECT name AS CityName FROM city AS cities;

-- Alias can also be used to create shorthand references, such c for city and co for country.
--SELECT c.name, co.name FROM city AS c, country AS co;

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)
--SELECT name, population FROM city WHERE countryCode='USA' ORDER BY name ASC, population DESC;

-- Limiting results allows rows to be returned in 'limited' clusters where LIMIT says how many, and an optional OFFSET specifies number of rows to skip
--SELECT name, population FROM city LIMIT 10 OFFSET 10;

-- Postgres has a number of string functions like SUBSTR. It also supports string concatenation, so we can build completed sentences if desired
--SELECT (name || ' is in the state of ' || district) AS city_state FROM city WHERE countryCode='USA';

-- Aggregate functions provide the ability to COUNT, SUM, AVG, and determine MIN and MAX. Only returns a single row of value(s).
--SELECT COUNT(name) AS city_count FROM city;  -- Counts the number of rows
--SELECT COUNT(population) FROM city;		-- Counts the number of rows
--SELECT SUM(population) AS total_city_population, COUNT(population) as number_of_cities, AVG(population) AS avergage_population FROM city;
SELECT MIN(population) AS smallest_population, MAX(population) AS largest_population FROM city;

-- GROUP BY clusters rows by a column value
SELECT  countrycode, MIN(population), MAX(population) FROM city GROUP BY countrycode;
