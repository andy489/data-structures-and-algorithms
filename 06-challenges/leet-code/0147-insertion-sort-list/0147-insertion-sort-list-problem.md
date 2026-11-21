# 147. Insertion Sort List

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/insertion-sort-list/

---

## Problem Statement

Given the `head` of a singly linked list, sort the list using **insertion sort**, and return the sorted list's head.

**Steps of the insertion sort algorithm:**

1. Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
2. At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
3. It repeats until no input elements remain.

---

## Examples

**Example 1:**
```
Input:  head = [4,2,1,3]
Output: [1,2,3,4]
```

**Example 2:**
```
Input:  head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
```

---

## Constraints

- The number of nodes in the list is in the range `[1, 5000]`.
- `-5000 <= Node.val <= 5000`
