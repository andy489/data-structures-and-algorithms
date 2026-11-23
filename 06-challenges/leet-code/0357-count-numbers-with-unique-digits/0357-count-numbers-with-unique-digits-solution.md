# 357. Count Numbers with Unique Digits — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-numbers-with-unique-digits/

---

## Solution: Combinatorics — O(1) time, O(1) space

**Idea:** Count how many k-digit numbers (k = 1..n) have all unique digits using the multiplication principle. A 1-digit number has 9 choices (1–9); for each additional digit we have fewer available choices.

**Algorithm:**
1. For `n = 0` return 1.
2. Start with `count = 10` (0–9 for n=1).
3. For each additional digit position `k` from 2 to n: multiply by `(10 - (k-1))` available choices, add to count.

**Complexity:**

| | |
|---|---|
| Time | O(1) — at most 8 iterations |
| Space | O(1) |
