# 3906. Count Good Integers on a Grid Path

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/count-good-integers-on-a-grid-path/

## Problem

You are given two integers `l` and `r`, and a string `directions` consisting of **exactly** three `'D'` characters and three `'R'` characters.

For each integer `x` in the range `[l, r]` (inclusive), perform the following steps:

1. If `x` has fewer than 16 digits, pad it on the left with **leading zeros** to obtain a 16-digit string.
2. Place the 16 digits into a `4 × 4` grid in **row-major** order.
3. Starting at the **top-left** cell `(row=0, column=0)`, apply the 6 characters of `directions` in order:
   - `'D'` increments the row by 1.
   - `'R'` increments the column by 1.
4. Record the sequence of digits visited along the path (including the starting cell), producing a sequence of length 7.

The integer `x` is considered **good** if the recorded sequence is **non-decreasing**.

Return an integer representing the number of good integers in the range `[l, r]`.

## Examples

**Example 1:**
```
Input: l = 8, r = 10, directions = "DDDRRR"
Output: 2

Explanation: 8 and 9 are good (path visits [0,0,0,0,0,0,8] and [0,0,0,0,0,0,9]); 10 is not good.
```

**Example 2:**
```
Input: l = 123456789, r = 123456790, directions = "DDRRDR"
Output: 1
```

**Example 3:**
```
Input: l = 1288561398769758, r = 1288561398769758, directions = "RRRDDD"
Output: 0
```

## Constraints

- `1 <= l <= r <= 9 * 10^15`
- `directions.length == 6`
- `directions` consists of exactly three `'D'` characters and three `'R'` characters.
