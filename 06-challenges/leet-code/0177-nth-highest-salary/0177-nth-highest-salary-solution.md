# 177. Nth Highest Salary — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/nth-highest-salary/

---

## Solution: LIMIT / OFFSET — O(n log n) time, O(1) space

**Idea:** Sort distinct salaries in descending order and skip the first `n-1` rows; the next row is the nth highest. Because `OFFSET` requires a literal or variable, we compute `n - 1` inside the stored function. `IFNULL` wraps the subquery so an empty result returns `NULL` rather than no rows.

**Algorithm:**
1. Declare `m INT` and set `m = N - 1`.
2. `SELECT DISTINCT salary FROM Employee ORDER BY salary DESC LIMIT 1 OFFSET m`.
3. Wrap with `IFNULL(..., NULL)` aliased as `getNthHighestSalary(N)`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sorting |
| Space | O(1) — result is a single scalar value |

---

## Solution 2: DENSE_RANK window function — O(n log n) time, O(n) space

**Idea:** Assign a dense rank to each distinct salary in descending order; the row whose rank equals `N` is the answer. `DENSE_RANK` handles ties correctly — equal salaries share a rank without a gap.

**Algorithm:**
1. Subquery: `SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rk FROM Employee`.
2. Outer: `WHERE rk = N LIMIT 1`.
3. Wrap with `IFNULL(..., NULL)`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — window function requires a sort pass |
| Space | O(n) — intermediate ranked result set holds all rows |

---

## Solution 3: Correlated subquery — O(n²) time, O(1) space

**Idea:** A salary is the nth highest if exactly `N-1` distinct salaries are strictly greater than it. The correlated subquery counts those salaries for every candidate row — no sorting or window function needed, but it rescans the table once per outer row.

**Algorithm:**
1. For each distinct `e1.salary`, count `DISTINCT e2.salary WHERE e2.salary > e1.salary`.
2. Keep the row where that count equals `N - 1`.
3. Wrap with `IFNULL(..., NULL)`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — inner subquery runs once per outer row |
| Space | O(1) — no intermediate storage beyond scalar aggregates |
