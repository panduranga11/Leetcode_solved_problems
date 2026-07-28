SELECT MAX(salary) AS SecondHighestSalary FROM(
SELECT salary,DENSE_RANK() OVER(ORDER BY salary DESC) as rnk
FROM Employee) as rr
WHERE rnk=2;