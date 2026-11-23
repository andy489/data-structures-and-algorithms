# 464. Can I Win — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/can-i-win/

---

## Solution: Bitmask DP (Memoization) — O(2^n · n) time, O(2^n) space

**Idea:** Represent used integers as a bitmask. For each state (which integers have been used + whose turn it is), determine if the current player can win. Memoize by bitmask.

**Algorithm:**
1. If `desiredTotal <= 0`, first player wins immediately.
2. If sum of all integers `1..max < desiredTotal`, nobody can win.
3. DFS with bitmask: at each turn, try all unused integers. If picking `i` reaches `>= desiredTotal`, win. Else recurse; if opponent loses, we win.
4. Memoize bitmask → boolean.

**Complexity:**

| | |
|---|---|
| Time | O(2^n · n) — 2^n states × n choices each |
| Space | O(2^n) — memoization table |
