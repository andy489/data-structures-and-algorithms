# 3348. Smallest Divisible Digit Product II — Solution

## Approach: Prime Factorization + Digit DP / Greedy Construction

**Key observations:**
1. Only digits 1–9 can appear (zero-free). The possible digit prime factors are only 2, 3, 5, and 7 (primes ≤ 9).
2. If `t` has any prime factor other than 2, 3, 5, or 7, return `"-1"` (impossible to achieve with single digits).
3. We need to find the smallest number ≥ `num` whose digits are all nonzero and whose product's prime factorization covers the required powers of 2, 3, 5, 7.

**Algorithm:**
1. Factorize `t` into 2^a * 3^b * 5^c * 7^d. If other primes remain, return `"-1"`.
2. Try to build the answer with the same number of digits as `num` first (using the "tight constraint" approach).
3. If not possible with the same length, use the minimum digits needed to achieve the product divisibility with the smallest possible number (prepend needed digits, fill rest with 1s).

**Tight constraint construction:**
- Try each position from left to right.
- For each position, try digits from (current digit at this position) to 9.
- If we're no longer "tight" (chose a larger digit at some previous position), fill remaining positions with 1s and check if achievable.
- Track remaining required factors as we assign digits.

**Minimum length for a fresh number:**
- If same-length fails, we need length L+1 (or more). The minimum product digit combination to cover a^b*c^d with minimum digits: greedily use 8, 9, 7, 5, etc. This gives the minimum number of digits needed. The answer would be 10^(minLen - 1) filled with 1s and the product digits.

## Complexity

- **Time:** O(n * 9 * states) where states involve the remaining prime factor powers (bounded by log(t) ≤ 47).
- **Space:** O(n + states).
