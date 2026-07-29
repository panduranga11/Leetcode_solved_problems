SELECT u as id ,counter as num FROM(
SELECT u,DENSE_RANK() OVER(ORDER BY counter DESC) as rnk,counter
FROM(SELECT user as u ,(SELECT COUNT(*) FROM RequestAccepted
WHERE requester_id=user OR  accepter_id =users.user) as counter
FROM
(SELECT accepter_id as user
FROM RequestAccepted
UNION
SELECT requester_id 
FROM RequestAccepted) as users) as t1) as ans
WHERE rnk=1;
 