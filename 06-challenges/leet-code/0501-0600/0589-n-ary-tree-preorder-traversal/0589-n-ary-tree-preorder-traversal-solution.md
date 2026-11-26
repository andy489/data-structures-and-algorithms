# 589. N-ary Tree Preorder Traversal — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/n-ary-tree-preorder-traversal/

---

## Solution 1: Recursive DFS — O(n) time, O(n) space

**Idea:** Visit root, then recursively visit each child left-to-right.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — recursion stack (depth of tree) |

## Solution 2: Iterative with Stack — O(n) time, O(n) space

**Idea:** Use an explicit stack. Push children in reverse order so the leftmost child is processed first.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
