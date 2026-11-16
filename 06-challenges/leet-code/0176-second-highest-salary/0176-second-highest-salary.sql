-- https://leetcode.com/problems/second-highest-salary/

-- Solution: Subquery with DISTINCT — O(n) time, O(1) space
SELECT (
    SELECT MAX(salary)
    FROM Employee
    WHERE salary < (SELECT MAX(salary) FROM Employee)
) AS SecondHighestSalary;

-- Solution 2: LIMIT / OFFSET — O(n log n) time, O(1) space
SELECT IFNULL(
    (SELECT DISTINCT salary
     FROM Employee
     ORDER BY salary DESC
     LIMIT 1 OFFSET 1),
    NULL
) AS SecondHighestSalary;

-- Solution 3: DENSE_RANK window function — O(n log n) time, O(n) space
SELECT IFNULL(
    (SELECT salary
     FROM (
         SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rk
         FROM Employee
     ) ranked
     WHERE rk = 2
     LIMIT 1),
    NULL
) AS SecondHighestSalary;
