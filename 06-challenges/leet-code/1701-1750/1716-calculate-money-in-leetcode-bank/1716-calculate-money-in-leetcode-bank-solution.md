# 1716. Calculate Money in Leetcode Bank — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/calculate-money-in-leetcode-bank/

---

## Solution: Math Formula — O(1) time, O(1) space

**Idea:** Compute complete weeks and remaining days. Each week `w` (0-indexed) starts on Monday with `w+1` dollars and goes up to `w+7`. Week sum = 7*(w+1) + (0+1+...+6) = 7w + 28. Sum of `W` complete weeks = 7*(0+1+...+(W-1)) + 28*W = 7*W*(W-1)/2 + 28*W. Remaining `r` days start at `W+1` and go to `W+r`. Their sum = r*(W+1) + (0+1+...+(r-1)) = r*(W+1) + r*(r-1)/2.

**Algorithm:**
1. W = n / 7, r = n % 7.
2. Full weeks sum = 7 * W*(W-1)/2 + 28*W.
3. Partial week sum = r*(W+1) + r*(r-1)/2.
4. Return total.

**Complexity:**

| | |
|---|---|
| Time | O(1) — arithmetic formula |
| Space | O(1) — no extra storage |
