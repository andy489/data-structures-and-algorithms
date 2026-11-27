# 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/

---

## Problem Statement

A **critical point** in a linked list is either a local maxima or minima. Return `[minDistance, maxDistance]` between any two critical points, or `[-1,-1]` if fewer than 2 exist.

---

## Examples

**Example 1:**
```
Input:  head = [3,1]
Output: [-1,-1]
```
Explanation: No critical points.

**Example 2:**
```
Input:  head = [5,3,1,2,5,1,2]
Output: [1,3]
```
Explanation: Critical points at indices 1,3,4.

**Example 3:**
```
Input:  head = [1,3,2,2,3,2,2,2,7]
Output: [3,3]
```

---

## Constraints

- `The number of nodes in the list is in the range [2, 10^5].`
- `1 <= Node.val <= 10^5`
