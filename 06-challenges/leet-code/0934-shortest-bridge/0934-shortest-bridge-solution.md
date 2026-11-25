# 934. Shortest Bridge — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-bridge/

---

## Solution: DFS + BFS — O(n²) time, O(n²) space

**Idea:** DFS to find and mark first island, add all its cells to BFS queue. BFS expands outward counting steps; first time we hit the second island is the answer.

**Algorithm:**
1. DFS from first `1` found to mark entire island with 2, adding all cells to BFS queue.
2. BFS level by level expanding to 0s (water) and return steps when hitting a 1.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) |
