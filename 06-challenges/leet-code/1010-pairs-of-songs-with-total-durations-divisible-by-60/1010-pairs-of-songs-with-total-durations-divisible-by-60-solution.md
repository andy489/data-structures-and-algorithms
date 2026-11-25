# 1010. Pairs of Songs With Total Durations Divisible by 60 — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

---

## Solution: Two Sum Variant with mod 60 — O(n) time, O(1) space

**Idea:** Similar to Two Sum. For each song with remainder r = time%60, we need to find previous songs with remainder (60-r)%60. Keep a count array of size 60.

**Algorithm:**
1. For each song t, r = t%60, complement = (60-r)%60.
2. Add count[complement] to answer.
3. Increment count[r].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) — fixed 60-element array |
