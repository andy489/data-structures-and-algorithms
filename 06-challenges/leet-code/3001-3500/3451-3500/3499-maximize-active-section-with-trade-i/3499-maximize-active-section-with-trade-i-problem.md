# 3499. Maximize Active Section with Trade I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-active-section-with-trade-i/

---

## Problem Statement

You are given a binary string `s` of length `n`, where:

- `'1'` represents an **active** section.
- `'0'` represents an **inactive** section.

You can perform **at most one trade** to maximize the number of active sections in `s`. In a trade, you:

- Convert a contiguous block of `'1'`s that is surrounded by `'0'`s to all `'0'`s.
- Afterward, convert a contiguous block of `'0'`s that is surrounded by `'1'`s to all `'1'`s.

Return the **maximum** number of active sections in `s` after making the optimal trade.

**Note:** Treat `s` as if it is **augmented** with a `'1'` at both ends, forming `t = '1' + s + '1'`. The augmented `'1'`s **do not** contribute to the final count.

---

## Examples

**Example 1:**
```
Input: s = "01"
Output: 1
```

**Example 2:**
```
Input: s = "0100"
Output: 4
```

**Example 3:**
```
Input: s = "1000100"
Output: 7
```

**Example 4:**
```
Input: s = "01010"
Output: 4
```

---

## Constraints

- `1 <= n == s.length <= 10^5`
- `s[i]` is either `'0'` or `'1'`
