# 725. Split Linked List in Parts

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/split-linked-list-in-parts/

---

## Problem Statement

Given the `head` of a singly linked list and an integer `k`, split the linked list into `k` consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the **order of occurrence** in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the `k` parts.

---

## Examples

**Example 1:**
```
Input:  head = [1,2,3], k = 5
Output: [[1],[2],[3],[],[]]
```

**Example 2:**
```
Input:  head = [1,2,3,4,5,6,7,8,9,10], k = 3
Output: [[1,2,3,4],[5,6,7],[8,9,10]]
```

---

## Constraints

- The number of nodes in the list is in the range `[0, 1000]`.
- `0 <= Node.val <= 1000`
- `1 <= k <= 50`
