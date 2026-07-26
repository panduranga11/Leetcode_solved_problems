SELECT Department,Employee ,Salary FROM
(SELECT  D.name AS Department,E.name as Employee,salary as Salary,
DENSE_RANK() 
OVER(PARTITION BY departmentId ORDER BY salary DESC) as ranking
FROM Employee AS E
JOIN Department AS D
ON E.departmentId =D.id )  as rr
WHERE ranking IN (1,2,3);


