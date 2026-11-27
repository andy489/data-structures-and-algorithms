# 515. Find Largest Value in Each Tree Row — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-largest-value-in-each-tree-row/

---

## Solution: BFS Level Order — O(n) time, O(n) space

**Idea:** BFS processes nodes level by level. For each level, track maximum value.

**Algorithm:**
1. BFS queue starting with root.
2. For each level, dequeue all nodes, track max, enqueue children.
3. Append max to result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits all nodes |
| Space | O(n) — queue (widest level) |
