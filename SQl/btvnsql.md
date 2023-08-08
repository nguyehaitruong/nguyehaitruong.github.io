595. Big Countries
SELECT name, population, area
FROM World
WHERE area >= 3000000 OR population >= 25000000;
1890. The Latest Login in 2020
SELECT user_id,MAX(time_stamp    ) AS last_stamp          
FROM logins
WHERE YEAR(time_stamp) = 2020
GROUP BY user_id;
620. Not Boring Movies
SELECT id, movie, description, rating
FROM Cinema 
WHERE id % 2 = 1 AND description <> 'Boring'
ORDER BY rating DESC;
610. Triangle Judgement
ELECT x, y, z,
       CASE WHEN x + y > z THEN 'Yes' ELSE 'No' END AS triangle
FROM Triangle;
1729. Find Followers Count
SELECT user_id, COUNT(follower_id) AS followers_count
FROM followers
GROUP BY user_id
ORDER BY user_id ASC;
1050. Actors and Directors Who Cooperated At Least Three Times

SELECT actor_id, director_id
FROM ActorDirector
GROUP BY actor_id, director_id
HAVING COUNT(*) >= 3;

1484. Group Sold Products By The Date
511. Game Play Analysis I
SELECT player_id, MIN(event_date ) AS first_login
FROM Activity 
GROUP BY player_id;
175. Combine Two Tables
SELECT 
    p.firstName,
    p.lastName,
    a.city,
    a.state
FROM 
    Person p
LEFT JOIN 
    Address a
ON 
    p.personId = a.personId     ;
1757. Recyclable and Low Fat Products
SELECT product_id
FROM products
WHERE low_fats = 'Y' AND recyclable = 'Y';
1741. Find Total Time Spent by Each Employee
select event_day as day, emp_id, sum(out_time - in_time) as total_time
from Employees
group by day, emp_id
1693. Daily Leads and Partners
select date_id, make_name, 
    count(distinct lead_id) as unique_leads, 
    count(distinct partner_id) as unique_partners
from DailySales
group by date_id, make_name
2356. Number of Unique Subjects Taught by Each Teacher
SELECT teacher_id, COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id
1795. Rearrange Products Table
SELECT product_id, store, price
FROM Products
WHERE price IS NOT NULL;
1082. Sales Analysis I
select distinct seller_id
from Sales
group by seller_id
having sum(price) = (
    select sum(price) as max_price
    from Sales
    group by seller_id
    order by max_price desc
    limit 1)
2072. The Winner University
SELECT
    CASE
        WHEN n1.cnt > n2.cnt THEN 'New York University'
        WHEN n1.cnt < n2.cnt THEN 'California University'
        ELSE 'No Winner' 
    END AS winner

