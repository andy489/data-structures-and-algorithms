-- https://leetcode.com/problems/employees-earning-more-than-their-managers/

-- Solution 1: Self-join — O(n) time, O(1) space
SELECT e.name AS Employee
FROM Employee e
JOIN Employee m ON e.managerId = m.id
WHERE e.salary > m.salary;

-- Solution 2: Correlated subquery — O(n²) time, O(1) space
SELECT name AS Employee
FROM Employee e
WHERE managerId IS NOT NULL
  AND salary > (SELECT salary FROM Employee WHERE id = e.managerId);
