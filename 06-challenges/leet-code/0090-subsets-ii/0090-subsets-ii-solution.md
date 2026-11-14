# 90. Subsets II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/subsets-ii/

---

## Solution: Sort + Backtracking with Duplicate Skip — O(n·2^n) time, O(n) space

**Idea:** Sort the array so duplicates are adjacent. Use backtracking to build all subsets. At each recursion level, skip any element that equals the previous element at the same level (same `start` index) to avoid generating duplicate subsets.

**Algorithm:**
1. Sort `nums`.
2. Call `backtrack(start=0, current=[])`.
3. In `backtrack`: add a copy of `current` to results. For `i` from `start` to `n-1`:
   - If `i > start` and `nums[i] == nums[i-1]`, skip (same level duplicate).
   - Add `nums[i]`, recurse with `start=i+1`, then remove `nums[i]`.

**Complexity:**

| | |
|---|---|
| Time | O(n·2^n) — up to 2^n subsets, each copied in O(n) |
| Space | O(n) — recursion depth and current subset (excluding output) |
