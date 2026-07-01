SELECT s.product_id,e.first_year,s.quantity,s.price
FROM Sales AS s
JOIN (
    SELECT product_id,MIN(year) as first_year
    FROM Sales 
    GROUP BY product_id

) AS e
ON s.product_id=e.product_id AND s.year = e.first_year;