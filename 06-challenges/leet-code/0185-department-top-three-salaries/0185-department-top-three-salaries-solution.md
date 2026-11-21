# 185. Department Top Three Salaries — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/department-top-three-salaries/

---

## Solution: Dense Rank Window Function

**Idea:** Use `DENSE_RANK()` partitioned by department and ordered by salary descending. Keep rows where the rank ≤ 3.
