SELECT u.unique_id ,e.name
FROM Employees e
LEFT JOIN EmployeeUNI as u
ON e.id=u.id;