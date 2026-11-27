# Solution: Longest Subsequence With Decreasing Adjacent Difference

## Approach

DP with state: dp[i][d] = length of longest valid subsequence ending at index i with last absolute difference d.

For each i and j < i, with diff = |nums[i] - nums[j]|:
- For all d >= diff: dp[i][diff] = max(dp[i][diff], dp[j][d] + 1)

This is O(n^2 * maxVal) which is too slow.

Optimized: for each j, dp[j][d] contributes to dp[i][diff] where diff <= d. 

Define best[v][d] = max length of subsequence ending at value v with last diff d. When we process index i with nums[i] = val:
- For each previous value v and diff d >= |val-v|: dp[i][|val-v|] = max(best[v][d] + 1)

We need: for each prev value v, the max of best[v][d] for d >= |val-v|.

Precompute suffix max: maxFrom[v][d] = max(best[v][d], best[v][d+1], ..., best[v][maxD]).

Then for each i, for each prev value v: dp[i][|nums[i]-v|] = max(maxFrom[v][|nums[i]-v|] + 1).

After computing all for index i, update maxFrom[nums[i]].

Since nums[i] <= 300, values in [1,300], differences in [0,299].

## Complexity

| | Complexity |
|---|---|
| Time | O(n * maxVal) = O(n * 300) |
| Space | O(maxVal^2) = O(300^2) |
