SELECT e.name FROM Employee AS e
JOIN(
    
SELECT managerId 
FROM Employee
WHERE managerId IS NOT NULL
GROUP BY managerId
HAVING COUNT(*) >= 5

) as m
On e.id=m.managerId;
-- SELECT name FROM 
-- Employee WHERE id in(
-- SELECT managerId 
-- FROM Employee
-- WHERE managerId IS NOT NULL
-- GROUP BY managerId
-- HAVING COUNT(*) >= 5);