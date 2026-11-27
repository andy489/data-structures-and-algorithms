# Solution: 3418. Maximum Amount of Money Robot Can Earn

**Link:** https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/

## Approach

Dynamic Programming with 3D state: dp[i][j][neutralizations] = max coins reaching (i,j) with `neutralizations` skips used so far (0, 1, or 2).

- At each cell, the robot collects coins[i][j] normally, or if coins[i][j] < 0 and neutralizations remain, it can skip paying the penalty.
- Transition: dp[i][j][k] = max(dp[i-1][j][k], dp[i][j-1][k]) + effective_value(coins[i][j], k_remaining)

## Complexity

- Time: O(m * n)
- Space: O(m * n)
