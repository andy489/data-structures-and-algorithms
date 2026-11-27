# 1125. Smallest Sufficient Team — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-sufficient-team/

---

## Solution: Bitmask DP — O(people * 2^n) time, O(2^n) space

**Idea:** Since `req_skills.length <= 16`, encode every skill set as a bitmask. `dp[mask]` stores the smallest team (as a list of person indices) that covers exactly the skills in `mask`. Start with `dp[0] = []` (empty team covers no skills) and iterate over people, updating reachable masks.

**Algorithm:**
1. Assign each required skill an index 0..n-1. Build a skill-to-bit map.
2. For each person `i`, compute their skill bitmask `pmask`.
3. For every currently reachable state `mask` in `dp`:
   - Compute `next = mask | pmask`.
   - If `dp[next]` is unset or `dp[next].size > dp[mask].size + 1`, set `dp[next] = dp[mask] + [i]`.
4. Return `dp[(1 << n) - 1]`.

**Complexity:**

| | |
|---|---|
| Time | O(p * 2^n) — p people, n skills |
| Space | O(2^n) — dp table of size 2^n |
