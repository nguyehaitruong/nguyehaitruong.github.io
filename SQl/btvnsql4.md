1378. Replace Employee ID With The Unique Identifier
select unique_id, name
from Employees
left  join EmployeeUNI on Employees.id = EmployeeUNI.id
1795. Rearrange Products Table
ELECT product_id, 'store1' AS store, store1 AS price FROM Products WHERE store1 IS NOT NULL
UNION 
SELECT product_id, 'store2' AS store, store2 AS price FROM Products WHERE store2 IS NOT NULL
UNION 
SELECT product_id, 'store3' AS store, store3 AS price FROM Products WHERE store3 IS NOT NULL
ORDER BY 1,2 ASC
1587. Bank Account Summary II
SELECT u.name AS NAME,SUM(t.amount) AS BALANCE
FROM Transactions t  JOIN Users u
ON u.account = t.account
GROUP BY u.account 
HAVING SUM(t.amount)>10000;
1581. Customer Who Visited but Did Not Make Any Transactions

1251. Average Selling Price
SELECT p.product_id, ROUND(SUM(u.units*p.price)/SUM(u.units),2) AS average_price
FROM Prices p JOIN UnitsSold u USING(product_id)
WHERE u.purchase_date BETWEEN p.start_date AND p.end_date
GROUP BY p.product_id;
1303. Find the Team Size
SELECT e1.employee_id, COUNT(e1.employee_id) AS team_size
FROM Employee e1
INNER JOIN Employee e2 ON e1.team_id = e2.team_id
GROUP BY e1.employee_id;
1571. Warehouse Manager
SELECT name AS warehouse_name, SUM(units * vol) AS volume
FROM Warehouse w
JOIN (
    SELECT product_id, SUM(Width * Length * Height) AS vol
    FROM Products
    GROUP BY product_id
) p
ON w.product_id = p.product_id
GROUP BY name;
1421. NPV Queries
SELECT q.id, q.year, n.npv
FROM queries q
LEFT JOIN npv n
ON q.id = n.id;
1069. Product Sales Analysis II
select product_id, sum(quantity) as total_quantity
from Sales
group by product_id

