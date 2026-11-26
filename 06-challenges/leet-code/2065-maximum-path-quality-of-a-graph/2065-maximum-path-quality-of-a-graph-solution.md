# 2065. Maximum Path Quality of a Graph — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-path-quality-of-a-graph/

---

## Solution: DFS with Backtracking — O(n * maxTime) time, O(n * maxTime) space

**Idea:** DFS from node 0. Track visited counts, subtract time on return.

**Algorithm:**
1. DFS: keep count[node] for visits.
2. At node 0: update answer.
3. Prune: if remaining time < dist_to_0, skip.
4. Backtrack count on return.

**Complexity:**

| | |
|---|---|
| Time | O(n * maxTime) |
| Space | O(n * maxTime) |
