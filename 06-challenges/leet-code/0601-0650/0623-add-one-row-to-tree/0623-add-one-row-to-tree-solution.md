# 623. Add One Row to Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/add-one-row-to-tree/

---

## Solution: BFS Level Order — O(n) time, O(n) space

**Idea:** Use BFS to reach nodes at depth `depth-1`, then insert new nodes between each node and its children.

**Algorithm:**
1. If depth == 1, create new root with value val and attach original root as left child.
2. BFS until reaching level depth-1.
3. For each node at that level: create new left node with original left as its left child; create new right node with original right as its right child.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit up to n nodes |
| Space | O(n) — BFS queue |
