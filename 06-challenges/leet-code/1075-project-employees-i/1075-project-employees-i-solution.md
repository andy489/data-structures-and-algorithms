# 1075. Project Employees I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/project-employees-i/

---

## Solution: SQL

```sql
SELECT p.project_id, ROUND(AVG(e.experience_years), 2) AS average_years FROM Project p JOIN Employee e ON p.employee_id = e.employee_id GROUP BY p.project_id
```

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
