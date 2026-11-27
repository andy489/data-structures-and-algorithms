# 3333. Find the Original Typed String II

## Approach

**Runs + DP with prefix sums:**

First, compress `word` into runs of consecutive identical characters. Each run of length `L_i` can contribute a character between 1 and `L_i` times to the original string.

The total number of possible original strings is the product of all run lengths. But we need only strings with length >= k.

**Strategy: Total - (strings with length < k)**

Let `m` = number of runs, `runLen[i]` = length of run `i`.

Total = product of all run lengths (mod MOD).

For strings of length < k, use DP:
- `dp[j]` = number of ways to have total length exactly `j` for the first `i` runs
- Transition: for run `i` with length `L`, each choice contributes 1 to L characters
- Use prefix sums to optimize the sliding window transitions

Subtract the count of strings with length < k from the total.

## Complexity

- **Time:** O(n + m*k) where n = word.length, m = number of runs, k = minimum length
- **Space:** O(k) for DP array
