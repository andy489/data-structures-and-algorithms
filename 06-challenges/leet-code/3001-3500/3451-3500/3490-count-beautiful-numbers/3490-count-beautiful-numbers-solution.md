# 3490. Count Beautiful Numbers — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-beautiful-numbers/

---

## Solution: Digit DP — O(D * S * P * 2) time, O(D * S * P) space

**Idea:** Use digit DP where the state is `(position, sum_of_digits, product_of_digits, tight, started)`. Count numbers up to `n` where product % sum == 0. Apply inclusion-exclusion: answer = count(r) - count(l-1).

The product can be very large, but digits are 1-9 (product of up to 9 digits: max 9^9 ≈ 387M). The sum of digits is at most 9*9=81. We track the product mod each possible sum (1..81). We use GCD reduction: track `product mod lcm(1..81)` since we only need divisibility by any digit sum 1..81. LCM(1..81) is very large, so instead track sum (bounded by 81) and product mod LCM(1..81) (which divides the product exactly). Use memoization.

**Algorithm:**
1. Implement `count(n)` using digit DP with memoization.
2. State: `(pos, digitSum, productMod, tight, started)` where `productMod = product % LCM(1..81)`.
3. At the end of a number, check `productMod % digitSum == 0`.
4. Return `count(r) - count(l - 1)`.

**Complexity:**

| | |
|---|---|
| Time | O(D * 81 * LCM * 2) |
| Space | O(D * 81 * LCM) |
