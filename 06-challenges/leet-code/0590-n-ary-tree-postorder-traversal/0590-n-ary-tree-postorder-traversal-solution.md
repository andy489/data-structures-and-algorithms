# 590. N-ary Tree Postorder Traversal — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/n-ary-tree-postorder-traversal/

---

## Solution 1: Recursive DFS — O(n) time, O(n) space

**Idea:** Recursively visit all children left-to-right, then add root value.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — recursion stack |

## Solution 2: Iterative (reverse preorder) — O(n) time, O(n) space

**Idea:** Perform a modified preorder (root, then children right-to-left) and reverse the result to get postorder.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
