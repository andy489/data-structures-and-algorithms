# 1123. Lowest Common Ancestor of Deepest Leaves

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

---

## Problem Statement

Given the `root` of a binary tree, return the lowest common ancestor of its deepest leaves.

Recall that:
- The node of a binary tree is a leaf if and only if it has no children.
- The depth of the root of the tree is `0`. If the depth of a node is `d`, the depth of each of its children is `d + 1`.
- The lowest common ancestor of a set `S` of nodes is the node `A` with the largest depth such that every node in `S` is in the subtree with root `A`.

---

## Examples

**Example 1:**
```
Input:  root = [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation: We return the node with value 2. Nodes 7 and 4 are the deepest leaves (depth 3).
```

**Example 2:**
```
Input:  root = [1]
Output: [1]
Explanation: The root is the deepest node and is the LCA of itself.
```

**Example 3:**
```
Input:  root = [0,1,3,null,2]
Output: [2]
Explanation: The deepest leaf node is 2; the LCA of a single node is itself.
```

---

## Constraints

- The number of nodes in the tree will be in the range `[1, 1000]`.
- `0 <= Node.val <= 1000`
- The values of the nodes in the tree are unique.

> Note: This question is the same as 865: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
