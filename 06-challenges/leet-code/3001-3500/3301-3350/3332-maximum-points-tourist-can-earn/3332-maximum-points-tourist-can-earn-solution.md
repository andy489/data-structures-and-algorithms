# 3332. Maximum Points Tourist Can Earn

## Approach

**Dynamic Programming:**

Let `dp[i][c]` = maximum points achievable at the end of day `i`, being in city `c`.

**Transitions:**
- Stay in city `c` on day `i`: `dp[i][c] = dp[i-1][c] + stayScore[i][c]`
- Travel from city `prev` to city `c` on day `i`: `dp[i][c] = dp[i-1][prev] + travelScore[prev][c]`

**Base case:** `dp[0][c] = stayScore[0][c]` for all cities c (tourist can start at any city)

**Answer:** `max(dp[k-1][c])` over all cities `c`

We can optimize space to O(n) by only keeping the previous day's DP values.

## Complexity

- **Time:** O(k * n^2) where k = number of days, n = number of cities
- **Space:** O(n) using space-optimized DP
