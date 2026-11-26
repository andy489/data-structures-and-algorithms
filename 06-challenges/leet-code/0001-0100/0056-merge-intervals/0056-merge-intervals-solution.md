# 56. Merge Intervals — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/merge-intervals/

---

## Solution: Sort then Merge — O(n log n) time, O(n) space

**Idea:** Sort intervals by start value. Then scan left to right: if the current interval overlaps the last merged one (its start ≤ last end), extend the last end; otherwise push the current interval as a new merged entry.

**Algorithm:**
1. Sort `intervals` by `intervals[i][0]`.
2. Initialize `merged` with the first interval.
3. For each subsequent interval `[s, e]`:
   - If `s <= merged.last.end`: `merged.last.end = max(merged.last.end, e)`
   - Else: append `[s, e]` to `merged`
4. Return `merged`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sort |
| Space | O(n) — output list |
