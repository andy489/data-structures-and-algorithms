# 847. Shortest Path Visiting All Nodes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/shortest-path-visiting-all-nodes/

---

## Solution: BFS with Bitmask State — O(2^n · n) time, O(2^n · n) space

**Idea:** Use BFS where each state is `(node, visitedMask)`. Start from all nodes simultaneously (multi-source BFS). When `visitedMask == (1 << n) - 1`, all nodes have been visited.

**Algorithm:**
1. Initialize BFS queue with `(node, 1 << node)` for all nodes.
2. Use a visited set of `(node, mask)` pairs to avoid revisiting.
3. BFS level by level; return level when any state has full mask.

**Complexity:**

| | |
|---|---|
| Time | O(2^n · n) — 2^n masks × n nodes |
| Space | O(2^n · n) — visited set + queue |
