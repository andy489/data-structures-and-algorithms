# 3482. Analyze Organization Hierarchy — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/analyze-organization-hierarchy/

---

## Solution: Recursive CTE — O(n^2) time, O(n) space

**Idea:** Use a recursive CTE to traverse the hierarchy. First compute levels via recursive CTE. Then use self-join or recursive aggregation to compute team_size and budget for each manager.

**Algorithm:**
1. Use a recursive CTE `hierarchy` to assign levels: start with the CEO, then recursively join each employee's manager.
2. Use another CTE or correlated subquery to compute for each employee the sum of salaries and count of all employees in their subtree.
3. Combine results and order by level ASC, budget DESC, employee_name ASC.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
