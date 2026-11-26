-- https://leetcode.com/problems/rank-scores/

-- Solution 1: DENSE_RANK window function — O(n log n) time, O(n) space
SELECT
    score,
    DENSE_RANK() OVER (ORDER BY score DESC) AS `rank`
FROM Scores
ORDER BY score DESC;

-- Solution 2: Correlated subquery — O(n²) time, O(1) space
SELECT
    s1.score,
    (SELECT COUNT(DISTINCT s2.score)
     FROM Scores s2
     WHERE s2.score >= s1.score) AS `rank`
FROM Scores s1
ORDER BY s1.score DESC;
