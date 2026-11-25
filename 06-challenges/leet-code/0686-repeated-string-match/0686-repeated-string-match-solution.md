# 686. Repeated String Match — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/repeated-string-match/

---

## Solution: Repeat Until Length ≥ b + Check — O((n+m)/n · m) time, O(n+m) space

**Idea:** Minimum repeats needed is `ceil(b.length / a.length)`. Check that count and count+1.

**Algorithm:**
1. Repeat `a` until `repeated.length >= b.length`.
2. Check if `b` is substring; if yes return count.
3. Append `a` once more; check again. If yes return count+1.
4. Otherwise -1.

**Complexity:**

| | |
|---|---|
| Time | O((n+m) · m/n) — n=|a|, m=|b| |
| Space | O(n+m) — repeated string |
