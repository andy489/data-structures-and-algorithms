# 943. Find the Shortest Superstring — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-the-shortest-superstring/

---

## Solution: Bitmask DP — O(2^n × n²) time, O(2^n × n) space

**Idea:** Precompute overlap[i][j] = max suffix of words[i] matching prefix of words[j]. DP state: (mask, last) = min extra chars to include all words in mask ending with last. Reconstruct path.

**Algorithm:**
1. Precompute overlap matrix.
2. `dp[mask][i]` = min total length. Transition: add word j not in mask.
3. Backtrack to reconstruct the string.

**Complexity:**

| | |
|---|---|
| Time | O(2^n × n²) |
| Space | O(2^n × n) |
