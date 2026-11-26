# 1349. Maximum Students Taking Exam — Solution

## Approach
Bitmask DP. dp[row][mask] = max students if row `row` has seating mask. Check validity: no adjacent, no diagonal conflicts with previous row.

## Complexity
- Time: O(m * 4^n)
- Space: O(m * 2^n)
