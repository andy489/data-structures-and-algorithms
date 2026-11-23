# 513. Find Bottom Left Tree Value — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-bottom-left-tree-value/

---

## Solution: BFS Right-to-Left — O(n) time, O(n) space

**Idea:** Level-order traversal adding right child before left. The last node dequeued is the leftmost node of the last row.

**Algorithm:**
1. BFS queue starting with root.
2. At each step, enqueue right then left child (if present).
3. Track last dequeued node. After BFS, return its value.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits all nodes |
| Space | O(n) — queue |

---

## Solution 2: DFS — O(n) time, O(h) space

**Idea:** DFS tracking max depth seen. When we first reach a new max depth, record the node value (leftmost at that depth since we go left first).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(h) — recursion stack |
