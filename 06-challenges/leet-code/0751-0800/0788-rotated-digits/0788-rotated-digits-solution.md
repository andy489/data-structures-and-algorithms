# 788. Rotated Digits — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rotated-digits/

---

## Solution: Digit Check — O(n log n) time, O(log n) space

**Idea:** For each number, check that all its digits are valid (in {0,1,2,5,6,8,9}) and at least one is a "changing" digit (2, 5, 6, or 9).

**Algorithm:**
1. For each i in [1, n]: check digits.
2. Count if no invalid digit (3,4,7) and at least one changing digit (2,5,6,9).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — n numbers, log n digits each |
| Space | O(log n) — digit buffer |
