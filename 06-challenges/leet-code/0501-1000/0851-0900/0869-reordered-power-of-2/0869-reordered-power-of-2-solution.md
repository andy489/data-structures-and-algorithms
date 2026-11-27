# 869. Reordered Power of 2 — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reordered-power-of-2/

---

## Solution: Digit Frequency Comparison — O(log^2 n) time, O(log n) space

**Idea:** Sort the digit characters of n. For each power of 2 that has the same number of digits, sort its digit characters. If any match, return true.

**Algorithm:**
1. Compute sorted digit string of n.
2. For each power of 2 from 1 to 2^30: if same length, compare sorted digits.

**Complexity:**

| | |
|---|---|
| Time | O(log^2 n) |
| Space | O(log n) |
