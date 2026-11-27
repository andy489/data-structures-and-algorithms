# 3326. Minimum Division Operations to Make Array Non Decreasing

## Approach

The key insight is: dividing a number by its **greatest proper divisor** turns it into its **smallest prime factor**. This is because:

- For any number `x`, its greatest proper divisor is `x / p` where `p` is the smallest prime factor of `x`.
- Dividing `x` by `x/p` gives `p` (the smallest prime factor).

So each element can be reduced to either:
- Itself (no operation), or
- Its smallest prime factor (one operation)

**Algorithm:**
- Traverse from right to left
- If `nums[i] > nums[i+1]`, we must reduce `nums[i]` to its smallest prime factor
  - If the smallest prime factor is still > `nums[i+1]`, return -1
  - Otherwise, increment operations and update `nums[i]`

Precompute smallest prime factors using a sieve for efficiency.

## Complexity

- **Time:** O(M log log M + n) where M = 10^6 (sieve) and n = array length
- **Space:** O(M) for the smallest prime factor array
