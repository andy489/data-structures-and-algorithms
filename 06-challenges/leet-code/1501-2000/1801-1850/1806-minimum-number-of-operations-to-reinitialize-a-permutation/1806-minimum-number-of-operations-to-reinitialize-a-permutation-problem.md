# 1806. Minimum Number of Operations to Reinitialize a Permutation

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/

---

## Problem Statement

You are given an even integer `n`. You have a permutation `perm` of size `n` where `perm[i] == i` (0-indexed).

In one operation, you will create a new array `arr` and for each `i`:

- If `i % 2 == 0`, then `arr[i] = perm[i / 2]`
- If `i % 2 == 1`, then `arr[i] = perm[n / 2 + (i - 1) / 2]`

You will then assign `arr` to `perm`.

Return the **minimum non-zero** number of operations you need to perform on `perm` to return the permutation to its initial value.

---

## Examples

**Example 1:**
```
Input: n = 2
Output: 1
Explanation: perm = [0,1] initially.
After operation 1: arr = [perm[0], perm[1]] = [0,1].
```

**Example 2:**
```
Input: n = 4
Output: 2
Explanation: perm = [0,1,2,3] initially.
After operation 1: arr = [0,2,1,3].
After operation 2: arr = [0,1,2,3].
```

**Example 3:**
```
Input: n = 6
Output: 4
```

---

## Constraints

- `2 <= n <= 1000`
- `n` is even
