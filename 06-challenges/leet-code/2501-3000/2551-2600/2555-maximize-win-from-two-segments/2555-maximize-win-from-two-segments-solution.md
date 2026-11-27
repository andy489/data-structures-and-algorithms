# 2555. Maximize Win From Two Segments — Solution

## Approach: Sliding Window + DP

**Key Insight:** Use a sliding window to count prizes in a segment of length `k`. Then use DP to combine two non-overlapping optimal segments.

**Algorithm:**
1. Use two pointers `l` and `r` to maintain a window `[prizePositions[l], prizePositions[l] + k]`.
2. `dp[i]` = maximum prizes from ONE segment ending at or before index `i`.
3. For each `r`, find the leftmost `l` such that `prizePositions[r] - prizePositions[l] <= k` using a pointer.
4. The window size is `r - l + 1`. Update `dp[r] = max(dp[r-1], r - l + 1)`.
5. For the answer: for each `r`, `ans = max(ans, dp[l - 1] + (r - l + 1))` where the second segment covers `[prizePositions[l], prizePositions[l] + k]`.

**Why dp[l-1]?** The best single segment ending before index `l` is `dp[l-1]`, and the current window is the second segment.

## Complexity

- **Time:** O(n) — single pass with two pointers
- **Space:** O(n) — for the dp array
