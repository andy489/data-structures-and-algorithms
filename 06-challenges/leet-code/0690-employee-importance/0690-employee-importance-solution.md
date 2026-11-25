# 690. Employee Importance — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/employee-importance/

---

## Solution: BFS — O(n) time, O(n) space

**Idea:** Build an id-to-employee map. BFS from given id, accumulating importance values.

**Algorithm:**
1. Build `idMap` from employee id to employee.
2. BFS: start with given id, add importance, enqueue all subordinates.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
