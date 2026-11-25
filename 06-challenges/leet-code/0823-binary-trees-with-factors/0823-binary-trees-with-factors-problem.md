# 823. Binary Trees With Factors

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-trees-with-factors/

---

## Problem Statement

Given an array of unique integers `arr`, each integer is strictly greater than 1. We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf node's value should be equal to the product of the values of its children.

Return the number of binary trees we can make. The answer may be too large, so return the answer modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  arr = [2,4]
Output: 3
Explanation: We can make [2],[4],[4,2,2]
```

**Example 2:**
```
Input:  arr = [2,4,5,10]
Output: 7
```

---

## Constraints

- `1 <= arr.length <= 1000`
- `2 <= arr[i] <= 10^9`
- All the values of `arr` are unique.
