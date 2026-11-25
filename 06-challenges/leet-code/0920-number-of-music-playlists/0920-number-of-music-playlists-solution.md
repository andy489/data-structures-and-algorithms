# 920. Number of Music Playlists — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-music-playlists/

---

## Solution: DP — O(goal × n) time, O(goal × n) space

**Idea:** `dp[i][j]` = number of playlists of length i using exactly j unique songs.
- Add a new song: `dp[i-1][j-1] * (n - (j-1))`
- Replay an old song (must not be one of last k): `dp[i-1][j] * max(0, j - k)`

**Algorithm:**
1. `dp[0][0] = 1`.
2. Transition as above.
3. Return `dp[goal][n]`.

**Complexity:**

| | |
|---|---|
| Time | O(goal × n) |
| Space | O(goal × n) |
