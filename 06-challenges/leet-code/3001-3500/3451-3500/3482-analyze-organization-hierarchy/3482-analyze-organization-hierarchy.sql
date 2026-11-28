-- https://leetcode.com/problems/analyze-organization-hierarchy/

-- Solution: Recursive CTE — O(n^2) time, O(n) space
WITH RECURSIVE hierarchy AS (
    -- Base case: CEO (no manager)
    SELECT employee_id, employee_name, manager_id, salary, 1 AS level
    FROM Employees
    WHERE manager_id IS NULL
    UNION ALL
    -- Recursive case: employees reporting to current level
    SELECT e.employee_id, e.employee_name, e.manager_id, e.salary, h.level + 1
    FROM Employees e
    JOIN hierarchy h ON e.manager_id = h.employee_id
),
subtree AS (
    -- For each employee, find all employees in their subtree (including themselves)
    SELECT ancestor.employee_id AS mgr_id, descendant.employee_id, descendant.salary
    FROM hierarchy ancestor
    JOIN hierarchy descendant ON descendant.employee_id = ancestor.employee_id
    UNION ALL
    SELECT ancestor.employee_id AS mgr_id, e.employee_id, e.salary
    FROM hierarchy ancestor
    JOIN Employees e ON e.manager_id = ancestor.employee_id
    -- We need full subtree, so use a different approach
),
-- Compute team_size and budget using ancestor relation
ancestors AS (
    SELECT e.employee_id, e.employee_id AS ancestor_id
    FROM Employees e
    UNION ALL
    SELECT a.employee_id, e.manager_id AS ancestor_id
    FROM ancestors a
    JOIN Employees e ON e.employee_id = a.employee_id
    WHERE e.manager_id IS NOT NULL
),
agg AS (
    SELECT
        ancestor_id AS employee_id,
        COUNT(*) - 1 AS team_size,
        SUM(e.salary) AS budget
    FROM ancestors a
    JOIN Employees e ON e.employee_id = a.employee_id
    GROUP BY ancestor_id
)
SELECT
    h.employee_id,
    h.employee_name,
    h.level,
    agg.team_size,
    agg.budget
FROM hierarchy h
JOIN agg ON agg.employee_id = h.employee_id
ORDER BY h.level ASC, agg.budget DESC, h.employee_name ASC;
