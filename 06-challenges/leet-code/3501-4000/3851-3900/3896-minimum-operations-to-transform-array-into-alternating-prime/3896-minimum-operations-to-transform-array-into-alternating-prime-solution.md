# Solution: 3896. Minimum Operations to Transform Array into Alternating Prime

## Approach: Sieve of Eratosthenes + Greedy

Precompute primes using the Sieve of Eratosthenes up to the maximum possible value needed (since we can only increment, we just need to find the next prime >= nums[i]).

### Algorithm

1. Build a sieve to mark all primes up to some limit.
2. For each index `i`:
   - If `i` is even: find the smallest prime >= `nums[i]`. Cost = `prime - nums[i]`.
   - If `i` is odd: find the smallest non-prime >= `nums[i]`. Cost = `non_prime - nums[i]`.
3. Sum all costs.

### Finding Next Non-Prime

For odd indices, we need the smallest composite number >= `nums[i]`. Since `4` is the first composite number, and 4 is not prime, for any value >= 4, we can check if it's prime and increment. For values 1 or 2, the next composite is 4.

Note: 1 is not prime (only factors are 1 itself, not two distinct factors). The problem says "prime is a natural number greater than 1 with only two factors", so 1 is non-prime. Wait: re-reading — the problem says 1 is non-prime since prime requires being > 1. So `1` is already a valid non-prime for odd positions.

### Upper Bound for Sieve

Since `nums[i] <= 10^5`, and the gap between consecutive primes is never too large (Bertrand's postulate: there's always a prime between n and 2n), we can safely sieve up to `2 * 10^5`.

## Complexity

- **Time:** O(LIMIT * log(log(LIMIT)) + N)
- **Space:** O(LIMIT) for the sieve
