# 87. Scramble String — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/scramble-string/

---

## Solution: Memoized Recursion — O(n^4) time, O(n^3) space

**Idea:** Recursively try every split point `k` (1 to n-1). For each split there are two cases:
- **No swap:** `isScramble(s1[0..k], s2[0..k]) && isScramble(s1[k..], s2[k..])`
- **Swap:** `isScramble(s1[0..k], s2[n-k..]) && isScramble(s1[k..], s2[0..n-k])`

Memoize results by the pair `(s1, s2)` to avoid recomputation. Early-exit optimizations: equal strings return `true`; different sorted characters return `false`.

**Algorithm:**
1. If `s1 == s2` return `true`.
2. If sorted characters differ return `false`.
3. For `k` from 1 to `n-1`:
   - Check no-swap and swap cases; return `true` if either holds.
4. Cache and return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n^4) — O(n^3) states × O(n) split loop |
| Space | O(n^3) — memoization map keyed by substring pairs |
