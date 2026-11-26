# 2074. Reverse Nodes in Even-Length Groups

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reverse-nodes-in-even-length-groups/

---

## Problem Statement

Given the head of a linked list, groups are formed in groups of increasing size 1, 2, 3... Reverse any group with an even number of nodes. Return the modified list.

---

## Examples

**Example 1:**
```
Input:  head = [5,2,6,3,9,1,7,3,8,4]
Output: [5,6,2,3,9,1,4,8,3,7]
```
Explanation: Groups: [5],[2,6],[3,9,1],[7,3,8,4]. Even groups: [2,6]→[6,2], [7,3,8,4]→[4,8,3,7].

**Example 2:**
```
Input:  head = [1,1,0,6]
Output: [1,0,1,6]
```

**Example 3:**
```
Input:  head = [1,1,0,6,5]
Output: [1,0,1,6,5]
```

---

## Constraints

- `The number of nodes in the list is in the range [1, 10^5].`
- `0 <= Node.val <= 10^5`
