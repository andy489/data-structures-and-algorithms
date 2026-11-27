# 3043. Find the Length of the Longest Common Prefix

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/

---

## Problem Statement

You are given two arrays with positive integers `arr1` and `arr2`.

A prefix of a positive integer is an integer formed by one or more of its digits, starting from its leftmost digit. For example, 123 is a prefix of 12345, and 12 is a prefix of 123.

A common prefix of two integers a and b is an integer c, such that c is a prefix of both a and b.

Return the length of the longest common prefix between all pairs of integers (x, y) such that x belongs to arr1 and y belongs to arr2.

If no common prefix exists among them, return 0.

---

## Examples

**Example 1:**
```
Input:  arr1 = [1,10,100], arr2 = [1000]
Output: 3
```

**Example 2:**
```
Input:  arr1 = [1,2,3], arr2 = [4,4,4]
Output: 0
```

---

## Constraints

- `1 <= arr1.length, arr2.length <= 5 * 10^4`
- `1 <= arr1[i], arr2[i] <= 10^8`
