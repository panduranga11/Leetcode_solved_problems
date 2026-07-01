SELECT customer_id
FROM Customer 
GROUP BY   customer_id
HAVING Count(DISTINCT  product_key)=(SELECT COUNT(*) FROM Product);