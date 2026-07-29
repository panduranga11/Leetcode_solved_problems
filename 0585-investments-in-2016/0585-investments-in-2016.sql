SELECT ROUND(SUM(tiv_2016),2) as tiv_2016 FROM
(SELECT *,COUNT(*) OVER(PARTITION BY  lat,lon ) as ctt
FROM
(SELECT *,COUNT(*) OVER(PARTITION BY tiv_2015  ) as cnt
FROM Insurance) as t1) as t2
WHERE ctt=1 && cnt>1;
