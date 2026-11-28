# 3483. Unique 3-Digit Even Numbers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/unique-3-digit-even-numbers/

---

## Solution: Brute Force Enumeration — O(1) time, O(1) space

**Idea:** Since digits are 0–9 and there are only 900 possible 3-digit even numbers (100–998, even), use a frequency count of available digits. For each 3-digit even number `n`, check if its three digits can be formed from the available digit counts.

**Algorithm:**
1. Count frequency of each digit in `digits`.
2. Iterate over all 3-digit even numbers from 100 to 998 (step 2).
3. For each, extract hundreds, tens, units digits; check if frequency allows forming the number.
4. Count valid numbers.

**Complexity:**

| | |
|---|---|
| Time | O(1) (bounded by 900 numbers * 10 digits) |
| Space | O(1) |
