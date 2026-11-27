# 1012. Numbers With Repeated Digits — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/numbers-with-repeated-digits/

---

## Solution: Digit DP (Complement Counting) — O(log n) time, O(log n) space

**Idea:** Count numbers WITHOUT repeated digits in [1,n], then subtract from n. Use permutation counting: for each prefix length, count valid completions using P(available_digits, remaining_positions).

**Algorithm:**
1. Convert n to digits array.
2. Count all numbers with fewer digits than n that have no repeats.
3. Count numbers with same digit count as n, digit by digit, that are < n with no repeats.
4. Answer = n - count_no_repeats.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — digit count |
| Space | O(log n) |
