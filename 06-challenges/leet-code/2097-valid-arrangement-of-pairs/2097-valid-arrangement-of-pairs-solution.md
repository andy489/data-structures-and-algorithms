# 2097. Valid Arrangement of Pairs — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/valid-arrangement-of-pairs/

---

## Solution: Eulerian Path (Hierholzer's Algorithm) — O(n) time, O(n) space

**Idea:** This is finding an Eulerian path. In-degree out-degree difference determines start node.

**Algorithm:**
1. Build directed graph.
2. Find start node (out-degree - in-degree == 1, or any node with edges).
3. Hierholzer's algorithm to find Eulerian path.
4. Reconstruct pairs from path.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
