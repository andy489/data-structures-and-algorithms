# 2055. Plates Between Candles

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/plates-between-candles/

---

## Problem Statement

You are given a string `s` of `'*'` (plate) and `'|'` (candle). For each query `[left, right]`, find the number of plates strictly between candles in the substring `s[left..right]`.

---

## Examples

**Example 1:**
```
Input:  s = "**|**|***|", queries = [[2,5],[5,9]]
Output: [2,3]
```

**Example 2:**
```
Input:  s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
Output: [9,0,0,0,0]
```

---

## Constraints

- `3 <= s.length <= 10^5`
- `s consists of '*' and '|'.`
- `1 <= queries.length <= 10^5`
- `queries[i].length == 2`
- `0 <= lefti <= righti < s.length`
