# 397. Integer Replacement

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/integer-replacement/

---

## Problem Statement

Given a positive integer `n`, you can apply one of the following operations:

1. If `n` is even, replace `n` with `n / 2`.
2. If `n` is odd, replace `n` with either `n + 1` or `n - 1`.

Return the minimum number of operations needed for `n` to become `1`.

---

## Examples

**Example 1:**
```
Input:  n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1
```

**Example 2:**
```
Input:  n = 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
  or 7 -> 6 -> 3 -> 2 -> 1
```

**Example 3:**
```
Input:  n = 4
Output: 2
```

---

## Constraints

- `1 <= n <= 2^31 - 1`
