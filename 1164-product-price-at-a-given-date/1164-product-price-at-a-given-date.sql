SELECT u.product_id, COALESCE(p.new_price, 10) AS price
FROM (SELECT DISTINCT(product_id) FROM products) as u
LEFT JOIN Products as p
ON u.product_id=p.product_id AND p. change_date=

(SELECT MAX(change_date) as latest
FROM Products
WHERE product_id=u.product_id  AND change_date <='2019-08-16'
 );




