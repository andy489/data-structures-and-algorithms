# 817. Linked List Components

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/linked-list-components/

---

## Problem Statement

You are given the `head` of a linked list containing unique integer values and an integer array `nums` that is a subset of the linked list values. Return the number of connected components in `nums` where two values are connected if they appear consecutively in the linked list.

---

## Examples

**Example 1:**
```
Input:  head = [0,1,2,3], nums = [0,1,3]
Output: 2
Explanation: 0 and 1 are connected, 3 is a separate component.
```

**Example 2:**
```
Input:  head = [0,1,2,3,4], nums = [0,3,1,4]
Output: 2
```

---

## Constraints

- The number of nodes in the linked list is `n`.
- `1 <= n <= 10^4`
- `0 <= Node.val < n`
- All values in the linked list are unique.
- `1 <= nums.length <= n`
- `0 <= nums[i] < n`
- All values of `nums` are unique.
