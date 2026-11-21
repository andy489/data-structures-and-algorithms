# 181. Employees Earning More Than Their Managers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/employees-earning-more-than-their-managers/

---

## Solution 1: Self-join — O(n) time, O(1) space

**Idea:** Join the `Employee` table to itself on `e.managerId = m.id`. This pairs each employee with their manager in one row, making the salary comparison trivial. Rows without a manager (NULL `managerId`) are excluded automatically by the inner join.

**Algorithm:**
1. `FROM Employee e JOIN Employee m ON e.managerId = m.id`
2. `WHERE e.salary > m.salary`
3. `SELECT e.name AS Employee`

**Complexity:**

| | |
|---|---|
| Time | O(n) — single join pass with index on `id` |
| Space | O(1) — no intermediate materialisation beyond the result |

---

## Solution 2: Correlated subquery — O(n²) time, O(1) space

**Idea:** For each employee that has a manager, look up the manager's salary in a correlated subquery and compare.

**Algorithm:**
1. `SELECT name AS Employee FROM Employee e`
2. `WHERE managerId IS NOT NULL`
3. `AND salary > (SELECT salary FROM Employee WHERE id = e.managerId)`

**Complexity:**

| | |
|---|---|
| Time | O(n²) — subquery executes once per outer row |
| Space | O(1) — scalar subquery, no intermediate storage |
