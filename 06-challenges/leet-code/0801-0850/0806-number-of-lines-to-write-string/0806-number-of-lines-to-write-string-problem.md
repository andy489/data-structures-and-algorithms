# 806. Number of Lines To Write String

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-lines-to-write-string/

---

## Problem Statement

You are given a string `s` of lowercase English letters and an array `widths` where `widths[0]` is the width of `'a'`, `widths[1]` is the width of `'b'`, etc. You are writing `s` across several lines where each line is at most 100 units wide. Write the string greedily, putting as many letters as possible on each line.

Return an array `result` of length 2: `result[0]` is the number of lines needed, `result[1]` is the width used in the last line.

---

## Examples

**Example 1:**
```
Input:  widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "abcdefghijklmnopqrstuvwxyz"
Output: [3,60]
```

---

## Constraints

- `widths.length == 26`
- `2 <= widths[i] <= 10`
- `1 <= s.length <= 1000`
- `s` contains only lowercase English letters.
