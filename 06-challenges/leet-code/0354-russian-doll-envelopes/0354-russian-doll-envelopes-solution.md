# 354. Russian Doll Envelopes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/russian-doll-envelopes/

---

## Solution: Sort + LIS with Binary Search — O(n log n) time, O(n) space

**Idea:** Sort envelopes by width ascending; for equal widths sort by height descending (to prevent using two envelopes with the same width). Then find the LIS on heights using patience sorting (binary search).

**Algorithm:**
1. Sort: ascending width, then descending height for ties.
2. Run LIS on the height sequence using binary search (`tails` array).
3. The length of `tails` is the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sort + LIS |
| Space | O(n) — tails array |
