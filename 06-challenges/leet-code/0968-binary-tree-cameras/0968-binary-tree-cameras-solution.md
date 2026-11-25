# 968. Binary Tree Cameras — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/binary-tree-cameras/

---

## Solution: Greedy DFS — O(n) time, O(h) space

**Idea:** Greedily place cameras at leaf parents. Each node returns: 0=not covered, 1=covered (no camera), 2=has camera.

**Algorithm:**
1. DFS post-order. If a child is not covered (returns 0), place a camera here.
2. If any child has a camera (returns 2), this node is covered.
3. Root: if it returns 0, add one more camera.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(h) — recursion |
