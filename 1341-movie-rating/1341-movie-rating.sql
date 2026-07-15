(SELECT name as results
FROM Users
WHERE user_id IN (
    SELECT user_id
    FROM (
        SELECT user_id, COUNT(*) AS c
        FROM MovieRating
        GROUP BY user_id
    ) uu
    WHERE c = (
        SELECT MAX(c)
        FROM (
            SELECT COUNT(*) AS c
            FROM MovieRating
            GROUP BY user_id
        ) t
    )
)
ORDER BY name
LIMIT 1)
UNION ALL
(SELECT title FROM
Movies WHERE
movie_id IN (
    SELECT movie_id 
    FROM (SELECT movie_id ,AVG(rating) as Avg 
    FROM MovieRating 
WHERE DATE_FORMAT(created_at,'%m-%Y')='02-2020'

GROUP BY  movie_id) as mv
WHERE mv.Avg =(
    SELECT MAX(Avg) FROM 
    (SELECT movie_id ,AVG(rating) as Avg FROM MovieRating 
WHERE DATE_FORMAT(created_at,'%m-%Y')='02-2020'
GROUP BY  movie_id) As t


)



)
ORDER BY title 
LIMIT 1);


