# 3857. Minimum Cost to Split into Ones — Solution

**Link:** https://leetcode.com/problems/minimum-cost-to-split-into-ones/

## Approach: Dynamic Programming

Let `dp[x]` = minimum cost to split `x` into all ones.

Base case: `dp[1] = 0` (already a single 1, no cost needed).

For `x > 1`, try all splits into `a + b = x` where `1 <= a <= x/2`:
```
dp[x] = min over a in [1, x-1] of (a * (x-a) + dp[a] + dp[x-a])
```

The answer is `dp[n]`.

**Observation:** Splitting into 1 + (n-1) gives cost `n - 1`, and recursing. The optimal strategy actually equals `n*(n-1)/2` (triangular number), which corresponds to always splitting off one 1 at a time. But DP confirms this.

## Complexity

- **Time:** O(n^2)
- **Space:** O(n)
