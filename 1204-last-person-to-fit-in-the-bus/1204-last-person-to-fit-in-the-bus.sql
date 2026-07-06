SELECT   q1.person_name FROM
Queue as q1
WHERE (SELECT SUM(weight)
FROM Queue
WHERE turn <=q1.turn)<=1000
ORDER BY q1.turn desc
LIMIT 1;