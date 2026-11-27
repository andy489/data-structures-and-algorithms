# 3336. Find the Number of Subsequences With Equal GCD

## Approach

**3D DP:**

Let `dp[i][g1][g2]` = number of ways to assign each element nums[0..i-1] to seq1 (with running GCD g1), seq2 (with running GCD g2), or neither.

For each element `nums[i]`:
- Skip it: `dp[i+1][g1][g2] += dp[i][g1][g2]`
- Add to seq1: `dp[i+1][gcd(g1, nums[i])][g2] += dp[i][g1][g2]`
- Add to seq2: `dp[i+1][g1][gcd(g2, nums[i])] += dp[i][g1][g2]`

(Where g1=0 means seq1 is empty so far; we update accordingly)

**Answer:** Sum of `dp[n][g][g]` for all g > 0.

Since nums[i] <= 200, GCD values are bounded by 200. The state space is O(n * 201 * 201) = O(n * 40401).

We can optimize with a 2D DP (rolling array over elements).

## Complexity

- **Time:** O(n * M^2) where M = max(nums[i]) = 200
- **Space:** O(M^2) with rolling array
