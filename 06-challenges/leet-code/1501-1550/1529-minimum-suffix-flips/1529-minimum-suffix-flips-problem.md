# 1529. Minimum Suffix Flips

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-suffix-flips/

---

## Problem Statement

You are given a string `target` of length `n` consisting only of characters `'0'` and `'1'`. You have an initial string `s` of length `n` with all '0' characters. You can do the following operation any number of times: choose any index `i` from `[0, n - 1]` and flip all characters from index `i` to index `n - 1`.

Return the minimum number of operations needed to make `s` equal to `target`.

---

## Examples

**Example 1:**
```
Input: target = "10111"
Output: 3
Explanation: Initially, s = "00000".
Choose index i = 0: s = "11111".
Choose index i = 1: s = "10000".
Choose index i = 2: s = "10111".
```

**Example 2:**
```
Input: target = "101"
Output: 3
```

**Example 3:**
```
Input: target = "00000"
Output: 0
```

---

## Constraints
- `n == target.length`
- `1 <= n <= 10^5`
- `target[i]` is either `'0'` or `'1'`.
