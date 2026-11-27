# 1443. Minimum Time To Collect All Apples In A Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

---

## Solution: DFS — O(n) time, O(n) space

**Idea:** DFS from root. Each subtree that has apples (directly or via children) requires 2 extra steps (down and back). Sum all such paths.

**Algorithm:**
1. Build adjacency list.
2. DFS: for each child, recurse to get child cost. If child cost > 0 or hasApple[child], add child cost + 2 to current node's cost.
3. Return total cost.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
