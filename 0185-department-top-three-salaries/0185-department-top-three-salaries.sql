SELECT Department, Employee, Salary
FROM (
    SELECT
        D.name AS Department,
        E.name AS Employee,
        E.salary AS Salary,
        DENSE_RANK() OVER (
            PARTITION BY E.departmentId
            ORDER BY E.salary DESC
        ) AS ranking
    FROM Employee AS E
    JOIN Department AS D
        ON E.departmentId = D.id
) AS rr
WHERE ranking IN (1, 2, 3);