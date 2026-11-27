# 117. Populating Next Right Pointers in Each Node II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

---

## Problem Statement

Given a binary tree:

```
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
```

Populate each `next` pointer to point to its next right node. If there is no next right node, the `next` pointer should be set to `NULL`.

Initially, all `next` pointers are set to `NULL`.

Unlike problem 116, the tree is **not** necessarily a perfect binary tree.

---

## Examples

**Example 1:**
```
Input:  root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
```

**Example 2:**
```
Input:  root = []
Output: []
```

---

## Constraints

- The number of nodes in the tree is in the range `[0, 6000]`.
- `-100 <= Node.val <= 100`

**Follow-up:** Could you solve it using only `O(1)` extra space?
