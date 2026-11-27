# 1420. Build Array Where You Can Find The Maximum Exactly K Comparisons

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons/

---

## Problem Statement

Return the number of arrays of length `n` where each value is in [1,m] and the search cost is exactly `k`. Cost = number of times a new maximum is found left to right. Mod 10^9+7.

---

## Examples

**Example 1:**
```
Input:  n=2,m=3,k=1
Output: 6
```

**Example 2:**
```
Input:  n=5,m=2,k=3
Output: 0
```

**Example 3:**
```
Input:  n=9,m=1,k=1
Output: 1
```

---

## Constraints

- `1 <= n <= 50`
- `1 <= m <= 100`
- `0 <= k <= n`
