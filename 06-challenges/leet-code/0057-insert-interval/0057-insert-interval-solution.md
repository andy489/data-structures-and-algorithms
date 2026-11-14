# 57. Insert Interval — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/insert-interval/

---

## Solution: Linear Scan — O(n) time, O(n) space

**Idea:** Walk through `intervals` in three phases:
1. Copy all intervals that end strictly before `newInterval` starts — they cannot overlap.
2. Merge all intervals that overlap with `newInterval` (i.e. their start ≤ `newInterval`'s end) by expanding `newInterval`'s bounds.
3. Copy the remaining intervals whose start is after the merged interval's end.

Two intervals `[a,b]` and `[c,d]` overlap iff `a <= d && c <= b`.

**Algorithm:**
1. Initialise `i = 0`, result list.
2. **Phase 1:** while `i < n` and `intervals[i][1] < newInterval[0]`, append `intervals[i++]`.
3. **Phase 2:** while `i < n` and `intervals[i][0] <= newInterval[1]`, expand `newInterval` to `[min(newInterval[0], intervals[i][0]), max(newInterval[1], intervals[i][1])]`, increment `i`.
4. Append merged `newInterval`.
5. **Phase 3:** append all remaining `intervals[i..]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the array |
| Space | O(n) — output array |
