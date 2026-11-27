# 1531. String Compression II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/string-compression-ii/

---

## Solution: DP with Run-Length Encoding — O(n^2 * k) time, O(n^2 * k) space

**Idea:** Use DP where `dp[i][j]` = minimum compressed length considering the first `i` characters with `j` deletions used. For each position i and deletion budget j, try extending a run from each previous position l: count same and different characters in [l..i], delete the different ones, and add the run-length cost.

**Algorithm:**
1. Initialize dp[0][0] = 0, everything else = infinity.
2. For each i from 1 to n, for each j from 0 to k:
   - Option A: delete s[i-1], so dp[i][j] = dp[i-1][j-1].
   - Option B: keep s[i-1] by scanning backwards from l=i to 1, tracking `same` (matches s[i-1]) and `diff` (others to delete). If j >= diff, update dp[i][j] = dp[l-1][j-diff] + runLength(same).
3. Answer is dp[n][k].

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * k) — O(n) choices of l for each of O(n * k) states |
| Space | O(n * k) — the dp table |
