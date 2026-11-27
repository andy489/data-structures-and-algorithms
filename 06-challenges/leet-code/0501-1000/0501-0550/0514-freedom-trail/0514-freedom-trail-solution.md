# 514. Freedom Trail — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/freedom-trail/

---

## Solution: DP — O(|key| × |ring|²) time, O(|key| × |ring|) space

**Idea:** `dp[i][j]` = minimum steps to spell `key[i..end]` when ring position `j` is at 12:00. For each key character, try all ring positions that match, taking the minimum rotation cost.

**Algorithm:**
1. Precompute positions of each character in ring.
2. `dp[i][j]` = min steps starting from key index i with ring at position j.
3. For each key char, for each current position, check all matching next positions: cost = min(clockwise, counterclockwise) + 1 (press).
4. Answer is min(dp[0][j]) for all j matching key[0].

**Complexity:**

| | |
|---|---|
| Time | O(m × n²) where m=key.length, n=ring.length |
| Space | O(m × n) — DP table |
