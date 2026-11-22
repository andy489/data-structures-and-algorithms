# 229. Majority Element II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/majority-element-ii/

---

## Solution: Boyer-Moore Voting (2 Candidates) — O(n) time, O(1) space

**Idea:** At most two elements can appear more than ⌊n/3⌋ times. Generalise Boyer-Moore to maintain two candidate/count pairs. On pass 1 find candidates; on pass 2 verify their actual counts.

**Algorithm:**
1. Maintain `(cand1, cnt1)` and `(cand2, cnt2)`.
2. For each `num`: if it matches a candidate, increment its count; else if a count is 0, replace; else decrement both.
3. Second pass: count occurrences of each candidate and include if `> n/3`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(1) |
