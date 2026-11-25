# 1028. Recover a Tree From Preorder Traversal — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

---

## Solution: Stack of Nodes by Depth — O(n) time, O(n) space

**Idea:** Parse dashes+digits. Maintain a stack where stack[depth] = last node at that depth. When placing a node at depth d, stack[d-1] is its parent; assign as left or right child.

**Algorithm:**
1. Parse traversal into (depth, val) pairs.
2. Stack keeps last node at each depth.
3. For each (depth, val): trim stack to depth; last in stack is parent; assign child.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
