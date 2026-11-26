# 814. Binary Tree Pruning — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-pruning/

---

## Solution: Recursive DFS — O(n) time, O(h) space

**Idea:** Recursively prune left and right subtrees. If a subtree contains no 1s, return null.

**Algorithm:**
1. Recursively prune left and right children.
2. If node has value 0 and both children are null, return null (prune this node).
3. Otherwise return the node.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit every node once |
| Space | O(h) — recursion stack height |
