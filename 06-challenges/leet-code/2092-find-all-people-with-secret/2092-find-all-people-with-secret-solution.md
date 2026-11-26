# 2092. Find All People With Secret — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-all-people-with-secret/

---

## Solution: BFS / Union-Find grouped by time — O(m log m) time, O(n + m) space

**Idea:** Group meetings by time. At each time step, union connected components, check if any in component knows secret, propagate.

**Algorithm:**
1. Sort meetings by time.
2. Process each group of same-time meetings:
3. Union-Find among participants.
4. If any person knows secret, entire component learns.
5. Reset components of people who didn't learn.

**Complexity:**

| | |
|---|---|
| Time | O(m log m) |
| Space | O(n + m) |
