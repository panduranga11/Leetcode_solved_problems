SELECT d.name AS Department,
       e.name AS Employee,
       e.salary AS Salary
FROM
(
    SELECT name,
           salary,
           departmentId
    FROM
    (
        SELECT *,
               DENSE_RANK() OVER(
                   PARTITION BY departmentId
                   ORDER BY salary DESC
               ) AS rnk
        FROM Employee
    ) x
    WHERE rnk = 1
) e
JOIN Department d
ON e.departmentId = d.id;
