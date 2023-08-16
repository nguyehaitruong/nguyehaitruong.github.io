1
SELECT  od.order_id ,p.product_name,od.quantity
from OrderDetails od
join products p on od.product_id =p.product_id 
where od.order_id='301';
2
SELECT SUM(p.price * od.quantity) AS total_amount
FROM OrderDetails od
JOIN Products p ON od.product_id = p.product_id
WHERE od.order_id = '302';
3
SELECT  p.*
from products p
join orderdetails od on od.product_id =p.product_id 
where p.product_id='101';
4
SELECT category_id, COUNT(*) AS total_products
FROM products
GROUP BY category_id;
5
SELECT customer_id, COUNT(*) AS total_products
FROM customers
GROUP BY customer_id;
6
SELECT category_id, COUNT(*) AS product_count
FROM products
GROUP BY category_id
ORDER BY product_count DESC
LIMIT 1;
7
SELECT category_id, COUNT(*) AS total_ordered
FROM categories
GROUP BY category_id;
8
SELECT category_id, COUNT(*) AS product_count
FROM products
GROUP BY category_id
ORDER BY product_count DESC
LIMIT 3;
9
SELECT c.customer_id,c.customer_name, COUNT(*) AS total_orders
FROM  customers c
join orders od on od.customer_id =c.customer_id 
WHERE od.order_date between '2023-08-01' and '2023-08-05'
GROUP BY customer_id, customer_name
having  COUNT(*)>1;
10
SELECT p.product_id, p.product_name, COUNT(od.order_id) AS total_ordered
FROM OrderDetails od
JOIN Products p ON od.product_id = p.product_id
GROUP BY p.product_id, p.product_name
ORDER BY total_ordered DESC
LIMIT 3;



