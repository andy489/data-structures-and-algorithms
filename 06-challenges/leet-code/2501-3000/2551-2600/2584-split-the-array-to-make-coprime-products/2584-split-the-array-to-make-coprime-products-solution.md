# Solution: 2584. Split the Array to Make Coprime Products

## Approach: Track Prime Factor Ranges

**Key Insight:** A split at index `i` is valid iff no prime factor appears in both `nums[0..i]` and `nums[i+1..n-1]`. Equivalently, for each prime `p` that appears in the array, all elements divisible by `p` must be entirely on one side of the split.

**Algorithm:**
1. For each index `j`, compute all prime factors of `nums[j]`.
2. For each prime `p`, track the first index `first[p]` and last index `last[p]` where `p` divides an element.
3. The interval `[first[p], last[p]]` must not be split — a split at `i` requires `i < first[p]` or `i >= last[p]`.
4. As we scan from left to right, maintain the maximum `last[p]` seen for any prime `p` encountered so far.
5. At each index `i`, if `i == maxRight` (the maximum last index of all primes seen), then the split at `i` is valid.

## Complexity

- **Time:** O(n * sqrt(max_val)) for factorization
- **Space:** O(n) for prime tracking
