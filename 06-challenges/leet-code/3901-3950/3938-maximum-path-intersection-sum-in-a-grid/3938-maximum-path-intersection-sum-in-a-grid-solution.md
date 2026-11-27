# 3938. Maximum Path Intersection Sum in a Grid

## Approach

Observe that Player 1 moves right/down from `(0,0)` to `(m-1,n-1)`, and Player 2 moves right/up from `(m-1,0)` to `(0,n-1)`. Both paths have length `(m-1) + (n-1)` steps.

Key insight: at step `s` (0-indexed, from 0 to m+n-2), Player 1 is at some cell `(r1, s-r1)` and Player 2 is at some cell `(r2, s-r2)` where `r1 + col1 = s` and `r2 + col2 = s`. They share the same column if and only if they are at the same column, meaning `s - r1 = s - r2`, i.e., `r1 = r2`. So they can only be at the same cell if `r1 = r2` at step `s`, which means they're at the same cell `(r, s-r)`.

Use DP: at each step `s`, track the best sum for each row position `r` for Player 1 (`dp1[r]`) and for each row position for Player 2 (`dp2[r]`). Then the shared sum is maximized by: at each step, for each row `r`, if both players can be at `(r, s-r)`, their combined contribution includes `grid[r][s-r]` once (not twice, since it's shared). If they're at different cells, the shared contribution is 0 for that step.

Actually we maximize the sum of cells that appear on both paths. We use 2D DP simultaneously: `dp[r1][r2]` = max sum of shared cells when Player 1 is at row `r1` and Player 2 is at row `r2`, both at step `s`. When `r1 == r2`, the cell is shared and contributes to the sum. When `r1 != r2`, it contributes 0.

## Complexity

- **Time:** O(m^2 * (m+n)) in worst case, but with the step compression O(m^2 * n) or O(m * n) with observation
- **Space:** O(m^2) — DP table per step
