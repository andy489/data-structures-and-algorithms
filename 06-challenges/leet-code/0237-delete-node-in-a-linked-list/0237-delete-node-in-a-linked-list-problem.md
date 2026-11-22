# 237. Delete Node in a Linked List

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-node-in-a-linked-list/

---

## Problem Statement

There is a singly-linked list `head` and we want to delete a node `node` in it.

You are given the node to be deleted `node`. You will **not be given access** to the first node of `head`.

All the values of the linked list are **unique**, and it is guaranteed that the given node `node` is not the last node in the linked list.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

- The value of the given node should not exist in the linked list.
- The number of nodes in the linked list should decrease by one.
- All the values before `node` should be in the same order.
- All the values after `node` should be in the same order.

---

## Examples

**Example 1:**
```
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
```

**Example 2:**
```
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
```

---

## Constraints

- The number of the nodes in the given list is in the range `[2, 1000]`.
- `-1000 <= Node.val <= 1000`
- The value of each node in the list is **unique**.
- The `node` to be deleted is **in the list** and is **not a tail** node.
