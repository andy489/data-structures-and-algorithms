# 596. Classes with at Least 5 Students — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/classes-with-at-least-5-students/

---

## Solution: GROUP BY with HAVING — O(n) time

**Idea:** Group by class, count distinct students per class, filter those with at least 5.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
