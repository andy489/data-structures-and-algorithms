# 22. Generate Parentheses — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/generate-parentheses/

---

## Solution: Backtracking — O(4ⁿ / √n) time, O(n) space

**Idea:** Build the string character by character. At each step we can place `(` if we haven't used all `n` opens, or `)` if the number of closes is less than the number of opens placed so far. When the string length reaches `2n` it is valid; record it. The total number of valid combinations is the nth Catalan number C(n) = C(2n, n) / (n+1) — for n=3 that is 5, for n=8 it is 1430.

**Algorithm:**
1. Define `backtrack(s, open, close)` where `s` is the current string, `open` is the count of `(` placed, and `close` is the count of `)` placed.
2. If `len(s) == 2n`, append `s` to the result.
3. If `open < n`, recurse with `s + "("`, `open + 1`, `close`.
4. If `close < open`, recurse with `s + ")"`, `open`, `close + 1`.
5. Call `backtrack("", 0, 0)` and return the result list.

**Complexity:**

| | |
|---|---|
| Time  | O(4ⁿ / √n) — the nth Catalan number bounds the output size |
| Space | O(n) — recursion depth is at most `2n` |
