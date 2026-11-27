-- https://leetcode.com/problems/consecutive-numbers/

-- Solution 1: LAG window function — O(n) time, O(n) space
WITH lagged AS (
    SELECT
        num,
        LAG(num, 1) OVER (ORDER BY id) AS prev1,
        LAG(num, 2) OVER (ORDER BY id) AS prev2
    FROM Logs
)
SELECT DISTINCT num AS ConsecutiveNums
FROM lagged
WHERE num = prev1 AND num = prev2;

-- Solution 2: Self-join on consecutive IDs — O(n) time, O(1) space
SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1
JOIN Logs l2 ON l2.id = l1.id + 1
JOIN Logs l3 ON l3.id = l1.id + 2
WHERE l1.num = l2.num AND l2.num = l3.num;
