# Solution: 3883. Count Non-Decreasing Arrays With Given Digit Sums

## Approach

For each `digitSum[i]`, precompute the list of valid numbers in `[0, 5000]` with that digit sum (call it `valid[i]`).

Then use DP: `dp[i][j]` = number of valid arrays where `arr[i] = valid[i][j]`.

Transition: for each `arr[i] = valid[i][j]`, count how many `arr[i-1] = valid[i-1][k]` satisfy `valid[i-1][k] <= valid[i][j]`.

Since `valid[i-1]` is sorted, use binary search or prefix sums.

**Optimization:** Use prefix sums on the previous DP row.
- Sort `valid[i-1]` (they come sorted naturally from iteration 0..5000).
- `dp[i][j] = sum of dp[i-1][k] for all k where valid[i-1][k] <= valid[i][j]`
- Use a prefix sum array on dp[i-1], and binary search for upper bound of `valid[i][j]` in `valid[i-1]`.

## Complexity

- **Time:** O(n * S * log(S)) where S = max numbers with given digit sum (at most ~O(5000) but precomputed once)
- **Space:** O(S) per step
