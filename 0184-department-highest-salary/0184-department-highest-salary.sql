SELECT   t2.name as Department ,t1.name as Employee ,t1.salary as Salary FROM
(SELECT name,salary,departmentId,DENSE_RANK() OVER(PARTITION BY departmentId
ORDER BY salary DESC) as rnk FROM Employee) as t1
JOIN Department As t2
ON t1.departmentId=t2.id
WHERE t1.rnk=1;
