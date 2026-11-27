# 3371. Identify the Largest Outlier in an Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/

---

## Solution: Frequency Map + Total Sum — O(n) time, O(n) space

**Idea:** Let `S = sum(nums)`. If candidate `o` (at some index) is the outlier, the remaining `n-1` elements must contain a valid sum element `sumElem` and the special numbers that add up to `sumElem`. Since `sumElem + (S - o - sumElem) = S - o`, we need `sumElem = (S - o) / 2`. For this to be valid:
1. `S - o` must be even.
2. `(S - o) / 2` must exist elsewhere in `nums`.
3. If `(S - o) / 2 == o`, its frequency must be >= 2 (we used one as outlier, need another as sum element).

We try all candidates, track the largest valid outlier.

**Algorithm:**
1. Compute total `S`.
2. Build a frequency map of `nums`.
3. For each element `o` in `nums` (tracking it was used once as outlier):
   - Compute `need = (S - o)`. Skip if odd.
   - `need /= 2`.
   - Temporarily decrement count of `o` in the map.
   - If `need` is in the map with count > 0, `o` is a valid outlier candidate.
   - Restore count.
4. Return the maximum valid outlier.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass + HashMap lookups |
| Space | O(n) — frequency map |
