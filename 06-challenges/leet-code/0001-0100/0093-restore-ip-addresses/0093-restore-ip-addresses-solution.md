# 93. Restore IP Addresses — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/restore-ip-addresses/

---

## Solution: Backtracking — O(1) time, O(1) space

**Idea:** Try all ways to split the string into exactly 4 segments using backtracking. At each step pick a segment of length 1, 2, or 3, validate it (value ≤ 255, no leading zeros), then recurse for the remaining parts. When 4 segments are placed and the string is fully consumed, record the result.

**Algorithm:**
1. Define `backtrack(start, parts)` where `start` is the current index and `parts` is the list of segments built so far.
2. Base case: if `len(parts) == 4` and `start == len(s)`, add `".".join(parts)` to results.
3. For length `1..3`: take `s[start:start+len]`, validate (no leading zero unless `"0"`, value ≤ 255), append to `parts`, recurse, then pop (backtrack).
4. Prune: if remaining characters can't possibly fill 4 − len(parts) segments (each 1–3 digits), stop early.

**Complexity:**

| | |
|---|---|
| Time | O(1) — at most 3⁴ = 81 combinations to try regardless of input length |
| Space | O(1) — recursion depth is at most 4; result list bounded by 81 entries |
