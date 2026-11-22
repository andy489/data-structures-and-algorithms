# 237. Delete Node in a Linked List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-node-in-a-linked-list/

---

## Solution: Copy-and-Skip — O(1) time, O(1) space

**Idea:** Since we don't have access to the previous node, copy the value of `node.next` into `node`, then skip `node.next`.

**Algorithm:**
1. `node.val = node.next.val`.
2. `node.next = node.next.next`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
