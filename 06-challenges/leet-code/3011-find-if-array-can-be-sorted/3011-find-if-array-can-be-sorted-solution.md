# 3011. Find if Array Can Be Sorted — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-if-array-can-be-sorted/

---

## Solution: Segment Max/Min Check — O(n) time, O(1) space

**Idea:** Elements with the same popcount can be freely reordered among themselves. Group consecutive elements with the same popcount into segments. For the array to be sortable, each segment's maximum must be ≤ the next segment's minimum.

**Algorithm:**
1. Group consecutive elements by popcount.
2. Track prevMax (max of previous segment).
3. For each new segment: if min of segment < prevMax, return false.
4. Update prevMax = max of current segment.
5. Return true.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
