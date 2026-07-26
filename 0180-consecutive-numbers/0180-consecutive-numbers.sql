SELECT DISTINCT num AS ConsecutiveNums
FROM(
SELECT num,
LAG (num) OVER (ORDER BY id) AS prev,
LEAD(num) OVER (ORDER BY id) AS next
FROM Logs) AS tb
WHERE num=tb.next AND num=tb.prev;
