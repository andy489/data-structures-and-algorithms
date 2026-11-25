# 935. Knight Dialer — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/knight-dialer/

---

## Solution: DP — O(n) time, O(1) space

**Idea:** Precompute knight moves for each digit 0–9. DP: `dp[d]` = ways to end at digit d after k steps. Transition using the adjacency list.

**Algorithm:**
1. Define moves for each digit.
2. For each step, compute new dp from old dp using moves.
3. Sum all dp[d] after n-1 transitions.

**Complexity:**

| | |
|---|---|
| Time | O(n × 10) = O(n) |
| Space | O(10) = O(1) |
