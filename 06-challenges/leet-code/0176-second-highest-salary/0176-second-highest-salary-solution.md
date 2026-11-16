# 176. Second Highest Salary — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/second-highest-salary/

---

## Solution: Subquery with DISTINCT — O(n) time, O(1) space

**Idea:** Select the maximum salary from all salaries that are strictly less than the overall maximum. Wrapping the subquery in an outer `SELECT` ensures `NULL` is returned when no second-highest value exists (rather than returning an empty result set).

**Algorithm:**
1. Inner query: `SELECT MAX(salary) FROM Employee WHERE salary < (SELECT MAX(salary) FROM Employee)`.
2. Outer `SELECT` with alias `SecondHighestSalary` so an empty inner result surfaces as `NULL`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear scans of the table |
| Space | O(1) — no intermediate storage beyond scalar aggregates |

---

## Solution 2: LIMIT / OFFSET — O(n log n) time, O(1) space

**Idea:** Sort the distinct salaries in descending order and take the second row. `IFNULL` wraps the result to guarantee `NULL` on an empty set.

**Algorithm:**
1. `SELECT DISTINCT salary FROM Employee ORDER BY salary DESC LIMIT 1 OFFSET 1`.
2. Wrap with `IFNULL(..., NULL)` inside a scalar subquery aliased as `SecondHighestSalary`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sorting |
| Space | O(1) — result is a single scalar value |

---

## Solution 3: DENSE_RANK window function — O(n log n) time, O(n) space

**Idea:** Assign a dense rank to each distinct salary in descending order; the row with rank 2 is the second highest. `DENSE_RANK` (not `RANK`) handles ties correctly — duplicate salaries share the same rank without leaving a gap. Wrapped in `IFNULL` to return `NULL` when rank 2 doesn't exist.

**Algorithm:**
1. Subquery: `SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rk FROM Employee`.
2. Outer query: `WHERE rk = 2 LIMIT 1`.
3. `IFNULL(..., NULL)` in a scalar subquery aliased `SecondHighestSalary`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — window function requires a sort pass |
| Space | O(n) — intermediate ranked result set holds all rows |
