# 1026. Maximum Difference Between Node and Ancestor — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

---

## Solution: DFS with Min/Max — O(n) time, O(h) space

**Idea:** At each node, track min and max values seen on the path from root. The max difference is max(|node.val - min|, |node.val - max|).

**Algorithm:**
1. DFS passing current path min and max.
2. At each node, update ans = max(ans, node.val-minAncestor, maxAncestor-node.val).
3. Recurse with updated min/max.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(h) |
