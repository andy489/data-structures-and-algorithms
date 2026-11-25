# 777. Swap Adjacent in LR String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/swap-adjacent-in-lr-string/

---

## Problem Statement

In a string composed of `'L'`, `'R'`, and `'X'` characters, like `"RXXLRXRXL"`, a move consists of either replacing one occurrence of `"XL"` with `"LX"`, or replacing one occurrence of `"RX"` with `"XR"`. Given the starting string `start` and the ending string `result`, return `true` if and only if there exists a sequence of moves to transform `start` to `result`.

---

## Examples

**Example 1:**
```
Input:  start = "RXXLRXRXL", result = "XRLXXRRLX"
Output: true
```

**Example 2:**
```
Input:  start = "X", result = "L"
Output: false
```

---

## Constraints

- `1 <= start.length <= 10^4`
- `start.length == result.length`
- Both `start` and `result` will only consist of characters in `'L'`, `'R'`, and `'X'`.
