# 1202. Smallest String With Swaps

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-string-with-swaps/

---

## Problem Statement

You are given a string `s` and an array of pairs of indices `pairs` where `pairs[i] = [a, b]` indicates you can swap `s[a]` and `s[b]` any number of times.

Return the lexicographically smallest string that `s` can be changed to after using the swaps.

---

## Examples

**Example 1:**
```
Input:  s = "dcab", pairs = [[0,3],[1,2]]
Output: "bacd"
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `0 <= pairs.length <= 10^5`
- `0 <= pairs[i][0], pairs[i][1] < s.length`
