# 2095. Delete the Middle Node of a Linked List

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

---

## Problem Statement

Given the head of a linked list, delete the middle node and return the modified list. Middle = floor(n/2) index (0-indexed).

---

## Examples

**Example 1:**
```
Input:  head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
```
Explanation: 7 at index 3 is deleted.

**Example 2:**
```
Input:  head = [1,2,3,4]
Output: [1,2,4]
```
Explanation: 3 at index 2 is deleted.

**Example 3:**
```
Input:  head = [2,1]
Output: [2]
```
Explanation: 1 at index 1 is deleted.

---

## Constraints

- `The number of nodes in the list is in the range [1, 10^5].`
- `1 <= Node.val <= 10^5`
