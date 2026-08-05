SELECT id FROM (
SELECT LAG(temperature) 
OVER(ORDER BY recordDate) AS prev,id,temperature,
LAG(recordDate) OVER(ORDER BY recordDate) AS pdate,recordDate
FROM Weather)
as t1
WHERE t1.temperature > t1.prev  AND DATE_ADD(pdate,INTERVAL 1 DAY)=recordDate;