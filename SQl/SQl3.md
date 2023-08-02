1741. Find Total Time Spent by Each Employee
select event_day as day, emp_id, sum(out_time - in_time) as total_time
from Employees
group by day, emp_id
2356. Number of Unique Subjects Taught by Each Teacher
SELECT teacher_id, COUNT(DISTINCT subject_id) AS cnt
FROM Teacher
GROUP BY teacher_id
1693. Daily Leads and Partners
elect date_id, make_name, 
    count(distinct lead_id) as unique_leads, 
    count(distinct partner_id) as unique_partners
from DailySales
group by date_id, make_name
1179. Reformat Department Table
ELECT
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
1350. Students With Invalid Departments
select id, name
from Students
where department_id not in (select id from Departments);
1777. Product’s Price for Each Store
select product_id, 
       sum(case when store='store1' then price else null end) as store1,
       sum(case when store='store2' then price else null end) as store2,
       sum(case when store='store3' then price else null end) as store3
from Products
group by product_id
1565. Unique Orders and Customers Per Month

select   count(distinct order_id) as order_count, 
	count(distinct customer_id) as customer_count
from orders
1173. Immediate Food Delivery I
SELECT ROUND(AVG(CASE WHEN order_date = customer_pref_delivery_date THEN 1 
        ELSE 0 END)*100,2) AS immediate_percentage
FROM Delivery
;