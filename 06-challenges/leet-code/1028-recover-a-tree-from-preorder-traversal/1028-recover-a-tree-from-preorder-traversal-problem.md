# 1028. Recover a Tree From Preorder Traversal

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/

---

## Problem Statement

We run a preorder depth-first search on the root of a binary tree.

At each node in this traversal, we output `D` dashes (where `D` is the depth of this node), then we output the node's value. If the depth of a node is `D`, the depth of its immediate children is `D + 1`. The root node has depth `0`.

Given the output `traversal` of this traversal, recover the tree and return its root.

---

## Examples

**Example 1:**
```
Input:  traversal = "1-2--3--4-5--6--7"
Output: [1,2,5,3,4,6,7]
```

---

## Constraints

- The number of nodes in the original tree is in the range `[1, 1000]`.
- `1 <= Node.val <= 10^9`
