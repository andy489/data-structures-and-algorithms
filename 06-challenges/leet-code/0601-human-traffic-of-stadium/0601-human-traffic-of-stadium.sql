-- https://leetcode.com/problems/human-traffic-of-stadium/

WITH big AS (
    SELECT id, visit_date, people,
           id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
),
groups AS (
    SELECT grp
    FROM big
    GROUP BY grp
    HAVING COUNT(*) >= 3
)
SELECT b.id, b.visit_date, b.people
FROM big b
JOIN groups g ON b.grp = g.grp
ORDER BY b.visit_date;
