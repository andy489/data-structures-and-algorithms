# 1008. Construct Binary Search Tree from Preorder Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

---

## Solution: Recursive with Bound — O(n) time, O(n) space

**Idea:** Use an index pointer and upper bound. The first element is the root. Recursively build left subtree (values < root) then right subtree (values < parent's bound).

**Algorithm:**
1. Maintain index `i` into preorder array.
2. `build(bound)`: if i >= n or preorder[i] > bound, return null.
3. Create node with preorder[i++], recurse left with bound=node.val, recurse right with original bound.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — recursion stack |
