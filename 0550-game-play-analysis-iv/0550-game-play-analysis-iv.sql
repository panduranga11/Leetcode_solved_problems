SELECT ROUND(
           COUNT(*) /
            (SELECT COUNT(*) FROM 
            (SELECT DISTINCT player_id FROM Activity) as x),
           2
       ) AS fraction
FROM
(
    SELECT player_id,
           MIN(event_date) AS flogin
    FROM Activity
    GROUP BY player_id
) AS a1
JOIN Activity AS a2
ON a1.player_id = a2.player_id
AND a2.event_date = DATE_ADD(a1.flogin, INTERVAL 1 DAY);