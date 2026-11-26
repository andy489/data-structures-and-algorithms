# 2080. Range Frequency Queries

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/range-frequency-queries/

---

## Problem Statement

Design a data structure that takes an integer array `arr` and can answer queries about the frequency of a value in a given range.

---

## Examples

**Example 1:**
```
Input:  arr = [12,33,4,56,22,2,34,33,22,12,34,56], query(1,2,4)=1, query(0,11,33)=2
Output: [1,2]
```

---

## Constraints

- `1 <= arr.length <= 10^5`
- `1 <= arr[i], value <= 10^4`
- `0 <= left <= right < arr.length`
- `At most 10^5 calls to query.`
