# 142. Linked List Cycle II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/linked-list-cycle-ii/

---

## Problem Statement

Given the `head` of a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the `next` pointer. The position `pos` is used to denote the index (0-indexed) of the node that the tail's `next` pointer is connected to. Note that `pos` is **not passed as a parameter**.

**Do not modify the linked list.**

---

## Examples

**Example 1:**

```
Input:  head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
```

**Example 2:**

```
Input:  head = [1,2], pos = 0
Output: tail connects to node index 0
```

**Example 3:**

```
Input:  head = [1], pos = -1
Output: no cycle
```

---

## Constraints

- The number of nodes in the list is in the range `[0, 10⁴]`
- `-10⁵ <= Node.val <= 10⁵`
- `pos` is `-1` or a valid index in the linked list

**Follow-up:** Can you solve it using `O(1)` memory?
