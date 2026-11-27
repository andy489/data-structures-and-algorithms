-- https://leetcode.com/problems/nth-highest-salary/

-- Solution: LIMIT / OFFSET — O(n log n) time, O(1) space
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    DECLARE m INT;
    SET m = N - 1;
    RETURN (
        SELECT IFNULL(
            (SELECT DISTINCT salary
             FROM Employee
             ORDER BY salary DESC
             LIMIT 1 OFFSET m),
            NULL)
    );
END

-- Solution 2: DENSE_RANK window function — O(n log n) time, O(n) space
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        SELECT IFNULL(
            (SELECT salary
             FROM (
                 SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rk
                 FROM Employee
             ) ranked
             WHERE rk = N
             LIMIT 1),
            NULL)
    );
END

-- Solution 3: Correlated subquery — O(n²) time, O(1) space
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        SELECT IFNULL(
            (SELECT DISTINCT e1.salary
             FROM Employee e1
             WHERE N - 1 = (
                 SELECT COUNT(DISTINCT e2.salary)
                 FROM Employee e2
                 WHERE e2.salary > e1.salary
             )),
            NULL)
    );
END
