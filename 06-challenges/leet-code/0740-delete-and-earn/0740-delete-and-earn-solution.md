# 740. Delete and Earn — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-and-earn/

---

## Solution: House Robber DP — O(n + max) time, O(max) space

**Idea:** Reduce to House Robber. Build `earn[v] = v * count(v)`. Taking value `v` means you can't take `v-1` or `v+1`, so it's exactly the House Robber problem on the earn array.

**Algorithm:**
1. Build `earn[1..maxVal]` where `earn[v] = v * frequency(v)`.
2. Run House Robber DP: `dp[i] = max(dp[i-1], dp[i-2] + earn[i])`.

**Complexity:**

| | |
|---|---|
| Time | O(n + max) — build earn array + DP scan |
| Space | O(max) — earn array |
