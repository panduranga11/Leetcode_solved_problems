
SELECT t1.name as employee FROM Employee AS t1 
JOIN Employee as t2 
ON t1.managerId=t2.id
WHERE t1.salary >t2.salary;

