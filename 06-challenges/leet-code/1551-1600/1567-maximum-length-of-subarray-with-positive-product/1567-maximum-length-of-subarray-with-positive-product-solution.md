# 1567. Maximum Length of Subarray With Positive Product — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/

---

## Solution: Two-Pass Greedy — O(n) time, O(1) space

**Idea:** A contiguous subarray has a positive product iff it has an even number of negatives (and no zeros). Split by zeros. Within each segment, if the negative count is even, the whole segment qualifies. If odd, we must exclude the leftmost or rightmost negative (whichever gives the longer subarray).

**Algorithm:**
1. Track `start` (position after last zero), `firstNeg` (index of first negative in current segment), and `negCount`.
2. For each element: if 0, reset; if negative, update count and firstNeg.
3. If even negatives, length is `i - start + 1`; if odd, exclude up to first negative: `i - firstNeg`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — a few variables |
