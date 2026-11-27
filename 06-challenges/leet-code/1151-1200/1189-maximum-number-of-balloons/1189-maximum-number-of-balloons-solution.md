# 1189. Maximum Number of Balloons — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-number-of-balloons/

---

## Solution: Frequency Count — O(n) time, O(1) space

**Idea:** Count the frequency of each character needed for "balloon" (b×1, a×1, l×2, o×2, n×1). The answer is the minimum of `count[b]`, `count[a]`, `count[l]/2`, `count[o]/2`, `count[n]`.

**Algorithm:**
1. Count occurrences of `b`, `a`, `l`, `o`, `n` in `text`.
2. Return `min(b, a, l/2, o/2, n)` using integer division.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass over text |
| Space | O(1) — only 5 counters |
