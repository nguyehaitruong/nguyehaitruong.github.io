2356. Number of Unique Subjects Taught by Each Teacher
SELECT teacher_id, COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id
1683. Invalid Tweets
ELECT tweet_id
FROM Tweets
WHERE length(content) > 15;
1795. Rearrange Products Table
SELECT product_id, store, price
FROM Products
WHERE price IS NOT NULL;
1587. Bank Account Summary II
SELECT u.name AS NAME,SUM(t.amount) AS BALANCE
FROM Transactions t  JOIN Users u
ON u.account = t.account
GROUP BY u.account 
HAVING SUM(t.amount)>10000;
627. Swap Salary
UPDATE Salary
SET sex  = CASE
    WHEN sex  = 'f' THEN 'm'
    WHEN sex  = 'm' THEN 'f'
    ELSE sex
END;
1068. Product Sales Analysis I
select p.product_name, s.year, s.price
from Sales s
join Product p
on s.product_id = p.product_id
1179. Reformat Department Table
SELECT
  id,
  SUM(CASE WHEN month = 'Jan' THEN revenue ELSE null END) AS Jan_revenue,
  SUM(CASE WHEN month = 'Feb' THEN revenue ELSE null END) AS Feb_revenue,
  SUM(CASE WHEN month = 'Mar' THEN revenue ELSE null END) AS Mar_revenue,
  SUM(CASE WHEN month = 'Apr' THEN revenue ELSE null END) AS Apr_revenue,
  SUM(CASE WHEN month = 'May' THEN revenue ELSE null END) AS May_revenue,
  SUM(CASE WHEN month = 'Jun' THEN revenue ELSE null END) AS Jun_revenue,
  SUM(CASE WHEN month = 'Jul' THEN revenue ELSE null END) AS Jul_revenue,
  SUM(CASE WHEN month = 'Aug' THEN revenue ELSE null END) AS Aug_revenue,
  SUM(CASE WHEN month = 'Sep' THEN revenue ELSE null END) AS Sep_revenue,
  SUM(CASE WHEN month = 'Oct' THEN revenue ELSE null END) AS Oct_revenue,
  SUM(CASE WHEN month = 'Nov' THEN revenue ELSE null END) AS Nov_revenue,
  SUM(CASE WHEN month = 'Dec' THEN revenue ELSE null END) AS Dec_revenue
FROM Department
GROUP BY id;
1484. Group Sold Products By The Date
select sell_date, count(distinct product) as num_sold,  group_concat(distinct product) as products
from Activities 
group by sell_date
order by sell_date
1890. The Latest Login in 2020
SELECT user_id,MAX(time_stamp    ) AS last_stamp          
FROM logins
WHERE YEAR(time_stamp) = 2020
GROUP BY user_id;
1251. Average Selling Price
ELECT p.product_id, ROUND(SUM(u.units*p.price)/SUM(u.units),2) AS average_price
FROM Prices p JOIN UnitsSold u USING(product_id)
WHERE u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;