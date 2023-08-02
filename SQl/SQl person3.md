SELECT *
FROM Person
WHERE job = 'Programmer' AND birthday > '2023-01-01';
 
SELECT COUNT(*) AS total_posts
FROM Person
WHERE YEAR(birthday) = 2022;

SELECT birthday
FROM Person 
WHERE YEAR(birthday) = 2022;

SELECT pr.id, pr.fullname, pr.country, pr.job, pr.gender
FROM Person pr
JOIN Post p ON pr.id = p.authorId
WHERE YEAR(p.createdAt) = 2022;
 
SELECT pr.id, pr.fullname, p.title
FROM Person pr
JOIN Post p ON pr.id = p.authorId
ORDER BY p.createdAt DESC
LIMIT 3;

SELECT authorId, COUNT(*) AS total_posts
FROM Post
GROUP BY authorId;

SELECT pr.id, pr.fullname, COUNT(p.id) AS total_posts
FROM Person pr
JOIN Post p ON pr.id = p.authorId
WHERE pr.country = 'China'
GROUP BY pr.id, pr.fullname;

SELECT pr.id, pr.fullname, COUNT(p.id) AS total_posts
FROM Person pr
JOIN Post p ON pr.id = p.authorId
WHERE pr.hobbies = 'Swimming' AND YEAR(p.createdAt) = 2023
GROUP BY pr.id, pr.fullname;

SELECT MONTH(createdAt) AS month, COUNT(*) AS total_posts
FROM Post
WHERE YEAR(createdAt) = 2023
GROUP BY MONTH(createdAt)
ORDER BY total_posts DESC
LIMIT 1;

SELECT YEAR(createdAt) AS year, COUNT(*) AS total_posts
FROM Post
GROUP BY YEAR(createdAt)
ORDER BY total_posts
LIMIT 1;

SELECT YEAR(createdAt) AS year, COUNT(*) AS total_posts
FROM Post
GROUP BY YEAR(createdAt)
ORDER BY total_posts DESC
LIMIT 1;

SELECT pr.id, pr.fullname, COUNT(p.id) AS total_posts
FROM Person pr
JOIN Post p ON pr.id = p.authorId
WHERE YEAR(p.createdAt) = 2023
GROUP BY pr.id, pr.fullname
ORDER BY total_posts DESC
LIMIT 1;

SELECT pr.id, pr.fullname, COUNT(p.id) AS total_posts
FROM Person pr
JOIN Post p ON pr.id = p.authorId
WHERE YEAR(p.createdAt) = 2022
GROUP BY pr.id, pr.fullname
HAVING COUNT(p.id) > 2;