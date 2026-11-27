# 2071. Maximum Number of Tasks You Can Assign — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/

---

## Solution: Binary Search + Greedy with Sorted Set — O(n log^2 n) time, O(n) space

**Idea:** Binary search on k (number of tasks assigned). For given k, greedy: use k easiest tasks and k strongest workers.

**Algorithm:**
1. Binary search on k.
2. For given k: sort tasks/workers, greedy assign from hardest task to weakest worker.
3. Use pill when needed: strongest available worker + pill.
4. If can assign all k, feasible.

**Complexity:**

| | |
|---|---|
| Time | O(n log^2 n) |
| Space | O(n) |
