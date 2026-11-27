# 1808. Maximize Number of Nice Divisors — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-number-of-nice-divisors/

---

## Solution: Greedy + Fast Power — O(log n) time, O(1) space

**Idea:** This problem reduces to the classic "Integer Break" (LC 343): split `primeFactors` into positive integers that sum to `primeFactors` and maximize their product. The number of nice divisors equals the product of the group sizes. The greedy insight is: always break into 3s, with special handling when the remainder is 1 (replace a 3+1 with 2+2 to get product 4 instead of 3).

**Algorithm:**
1. If `primeFactors <= 3`, the answer is `primeFactors` itself.
2. Compute `rem = primeFactors % 3` and `threes = primeFactors / 3`.
3. If `rem == 0`: answer is `3^threes % MOD`.
4. If `rem == 1`: one group of 4 is better than 3+1, so answer is `3^(threes-1) * 4 % MOD`.
5. If `rem == 2`: answer is `3^threes * 2 % MOD`.
6. Use fast modular exponentiation to handle the large exponents.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — fast power over exponent up to primeFactors/3 |
| Space | O(1) — only arithmetic variables |
