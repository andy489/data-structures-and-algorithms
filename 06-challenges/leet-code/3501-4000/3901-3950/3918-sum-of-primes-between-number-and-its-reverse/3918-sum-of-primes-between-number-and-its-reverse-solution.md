# Solution for 3918. Sum of Primes Between Number and Its Reverse

## Approach

**Simple prime enumeration:**

1. Reverse the digits of `n` to get `r`.
2. Determine `lo = min(n, r)` and `hi = max(n, r)`.
3. Sum all prime numbers in `[lo, hi]` using trial division or Sieve of Eratosthenes up to 1000.

Since `n <= 1000`, the range is at most [1, 1000], so a sieve is very efficient.

## Complexity

- Time: O(max_val * log(log(max_val))) for sieve, O(1) for query
- Space: O(max_val)
