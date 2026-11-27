# 334. Increasing Triplet Subsequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/increasing-triplet-subsequence/

---

## Solution: Two Variables — O(n) time, O(1) space

**Idea:** Maintain `first` and `second` as the smallest and second-smallest values seen so far in an increasing pair. If we find any value greater than `second`, a triplet exists.

**Algorithm:**
1. Initialize `first = second = Integer.MAX_VALUE`.
2. For each `num`:
   - If `num <= first`, update `first`.
   - Else if `num <= second`, update `second`.
   - Else return `true` (num > first > second found).
3. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
