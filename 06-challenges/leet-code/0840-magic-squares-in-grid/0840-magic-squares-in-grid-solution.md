# 840. Magic Squares In Grid — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/magic-squares-in-grid/

---

## Solution: Brute Force Check — O(rows·cols) time, O(1) space

**Idea:** For each top-left corner of a 3×3 subgrid, verify it's a magic square: all values 1–9 distinct, all rows/cols/diags sum to 15.

**Algorithm:**
1. Slide a 3×3 window over the grid.
2. For each window, check: values are a permutation of 1–9, all row sums = 15, all col sums = 15, both diag sums = 15.
3. Count valid windows.

**Complexity:**

| | |
|---|---|
| Time | O(rows·cols) — O(1) check per window |
| Space | O(1) — constant extra space |
