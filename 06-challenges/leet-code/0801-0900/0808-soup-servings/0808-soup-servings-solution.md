# 808. Soup Servings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/soup-servings/

---

## Solution: Memoized DP — O(1) amortized time, O(1) space

**Idea:** For large n (≥ 4800), the answer converges to 1.0. For smaller n, use memoized recursion scaled by 25ml units.

**Algorithm:**
1. If n >= 4800, return 1.0 (probability converges).
2. Scale n: use ceil(n/25) units. Operations become [4,0],[3,1],[2,2],[1,3].
3. dp(a,b) = 0.25*(dp(a-4,b)+dp(a-3,b-1)+dp(a-2,b-2)+dp(a-1,b-3)) with base cases.

**Complexity:**

| | |
|---|---|
| Time | O(n²/625) — bounded by ~200×200 grid |
| Space | O(n²/625) — memoization table |
