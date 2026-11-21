-- https://leetcode.com/problems/duplicate-emails/

-- Solution 1: GROUP BY + HAVING — O(n) time, O(n) space
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;

-- Solution 2: Self-join — O(n²) time, O(1) space
SELECT DISTINCT p1.email AS Email
FROM Person p1
JOIN Person p2 ON p1.email = p2.email AND p1.id <> p2.id;
