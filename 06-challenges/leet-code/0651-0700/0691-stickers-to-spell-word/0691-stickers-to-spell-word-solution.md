# 691. Stickers to Spell Word — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stickers-to-spell-word/

---

## Solution: DP with Bitmask — O(2^t · n · t) time, O(2^t) space

**Idea:** Represent covered target characters as a bitmask. `dp[mask]` = min stickers to cover the letters in mask. For each state, try applying each sticker.

**Algorithm:**
1. `dp[0] = 0`; all others infinity.
2. For each mask, for each sticker: compute new mask by reducing covered letters greedily.
3. `dp[newMask] = min(dp[newMask], dp[mask] + 1)`.
4. Return `dp[(1<<t)-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(2^t · n · t) |
| Space | O(2^t) |
