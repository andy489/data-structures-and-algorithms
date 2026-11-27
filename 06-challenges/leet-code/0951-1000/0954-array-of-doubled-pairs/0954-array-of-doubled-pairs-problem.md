# 954. Array of Doubled Pairs

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/array-of-doubled-pairs/

---

## Problem Statement

Given an integer array of even length `arr`, return `true` if it is possible to reorder `arr` such that `arr[2*i+1] = 2 * arr[2*i]` for every `0 <= i < len(arr) / 2`, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  arr = [3,1,3,6]
Output: false
```

**Example 2:**
```
Input:  arr = [2,1,2,1,1,1,2,2]
Output: true
```

---

## Constraints

- `2 <= arr.length <= 3 * 10^4`
- `arr.length` is even.
- `-10^5 <= arr[i] <= 10^5`
