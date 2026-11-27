# 2223. Sum of Scores of Built Strings — Solution

**Approach:** Z-Function (Z-Algorithm)

The Z-array for string `s` gives, for each position `i`, the length of the longest substring starting at `i` that matches a prefix of `s`. The score of `si` (the suffix starting at position `n - i`) is exactly `Z[n - i]`, capped at the suffix length. The sum of all scores is `n + sum(Z[1..n-1])`.

**Time Complexity:** O(n) — Z-algorithm is linear.

**Space Complexity:** O(n) — for the Z-array.
