# 942. DI String Match

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/di-string-match/

---

## Problem Statement

A permutation `perm` of `n + 1` integers of all the integers in the range `[0, n]` can be represented as a string `s` of length `n` where:
- `s[i] == 'I'` if `perm[i] < perm[i + 1]`, and
- `s[i] == 'D'` if `perm[i] > perm[i + 1]`.

Given a string `s`, reconstruct the permutation `perm` and return it. If there are multiple valid permutations perm, return **any of them**.

---

## Examples

**Example 1:**
```
Input:  s = "IDID"
Output: [0,4,1,3,2]
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s[i]` is either `'I'` or `'D'`.
