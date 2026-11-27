# 1295. Find Numbers with Even Number of Digits — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

---

## Solution: Digit Count — O(n log max) time, O(1) space

**Idea:** Count digits of each number; check if even.

**Algorithm:**
1. For each number, convert to string or repeatedly divide by 10.
2. Count digits; if even, increment answer.

**Complexity:**

| | |
|---|---|
| Time | O(n log max) |
| Space | O(1) |
