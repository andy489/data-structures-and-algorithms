# 919. Complete Binary Tree Inserter

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/complete-binary-tree-inserter/

---

## Problem Statement

A **complete binary tree** is one in which every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.

Design an algorithm to insert a new node to a complete binary tree keeping it complete after the insertion.

Implement the `CBTInserter` class:
- `CBTInserter(TreeNode root)` Initializes the data structure with the `root` of the complete binary tree.
- `int insert(int val)` Inserts a node with value `val` into the tree and returns the value of the parent.
- `TreeNode get_root()` Returns the root node.

---

## Examples

**Example 1:**
```
Input:  ["CBTInserter","insert","insert","get_root"]
        [[[1,2]],[3],[4],[]]
Output: [null,1,2,[1,2,3,4]]
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 1000]`.
- `0 <= Node.val <= 5000`
- `root` is a complete binary tree.
- `0 <= val <= 5000`
- At most `10^4` calls will be made to `insert` and `get_root`.
