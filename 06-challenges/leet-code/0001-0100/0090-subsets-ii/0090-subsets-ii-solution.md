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

---

## Solution 2: Iterative Insertion — O(n·2^n) time, O(1) space

**Idea:** Start with `[[]]`. For each number (in sorted order), append it to every existing subset to form new subsets. When the current number equals the previous one, only extend the subsets that were added in the previous round (not all existing ones) — this is exactly where the previous duplicate added new subsets, so extending only those avoids duplicates.

**Algorithm:**
1. Sort `nums`. Initialize `result = [[]]`, `prevSize = 0`.
2. For each `i` from `0` to `n-1`:
   - If `i > 0` and `nums[i] == nums[i-1]`: `start = prevSize` (extend only last-round subsets).
   - Else: `start = 0` (extend all existing subsets).
   - `prevSize = result.size()`.
   - For each subset in `result[start..prevSize-1]`, append `nums[i]` and add to `result`.

**Complexity:**

| | |
|---|---|
| Time | O(n·2^n) — same number of subsets generated |
| Space | O(1) — no recursion stack (excluding output) |
