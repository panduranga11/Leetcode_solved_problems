SELECT *,(SELECT COUNT(*) FROM Examinations e WHERE e.student_id=t1.student_id AND e.subject_name=t1.subject_name) as attended_exams
FROM
(SELECT * FROM Students as s 
CROSS JOIN Subjects as sb) as t1
ORDER BY t1.student_id ,t1.subject_name;
