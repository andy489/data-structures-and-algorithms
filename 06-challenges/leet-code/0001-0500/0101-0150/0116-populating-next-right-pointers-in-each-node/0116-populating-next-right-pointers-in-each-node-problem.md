# 116. Populating Next Right Pointers in Each Node

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

---

## Problem Statement

You are given a **perfect binary tree** where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

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

---

## Examples

**Example 1:**
```
Input:  root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
```
Explanation: each `#` denotes the end of a level (all `next` pointers in that level point right, with the last pointing to `NULL`).

**Example 2:**
```
Input:  root = []
Output: []
```

---

## Constraints

- The number of nodes in the tree is in the range `[0, 2^12 - 1]`.
- `-1000 <= Node.val <= 1000`

**Follow-up:** Could you solve it using only `O(1)` extra space?
