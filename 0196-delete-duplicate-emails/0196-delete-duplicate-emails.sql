DELETE FROM Person
WHERE id IN (
   
    (SELECT id FROM
(SELECT id, DENSE_RANK() 
OVER (PARTITION BY email
ORDER BY id) as rnkk
FROM Person
) as t1
WHERE t1.rnkk>=2
));


