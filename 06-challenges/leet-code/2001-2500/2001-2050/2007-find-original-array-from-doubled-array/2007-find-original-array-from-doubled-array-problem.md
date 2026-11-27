# 2007. Find Original Array From Doubled Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-original-array-from-doubled-array/

---

## Problem Statement

An original array `original` was doubled to create a doubled array `changed` by appending twice the value of every element in sorted order. Given the doubled array `changed`, return `original` if `changed` is a doubled array, or return an empty array if it is not possible.

**Note:** `original` may contain duplicates.

---

## Examples

**Example 1:**
```
Input:  changed = [1,3,4,2,6,8]
Output: [1,3,4]
```
Explanation: One possible original: [1,3,4] → doubled and sorted: [1,2,3,4,6,8].

**Example 2:**
```
Input:  changed = [6,3,0,1]
Output: []
```
Explanation: Not a valid doubled array.

**Example 3:**
```
Input:  changed = [3,1]
Output: []
```

---

## Constraints

- `1 <= changed.length <= 10^5`
- `0 <= changed[i] <= 10^5`
