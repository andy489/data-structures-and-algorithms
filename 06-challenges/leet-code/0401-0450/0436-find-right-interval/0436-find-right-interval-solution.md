# 436. Find Right Interval — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-right-interval/

---

## Solution: TreeMap Binary Search — O(n log n) time, O(n) space

**Idea:** Store all interval starts in a sorted map (start → original index). For each interval's end, do a ceiling lookup to find the smallest start >= end.

**Algorithm:**
1. Build a TreeMap mapping `start → index` for all intervals.
2. For each interval `[start, end]`, query `ceilingKey(end)` on the TreeMap.
3. If found, store the mapped index; otherwise store -1.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — n TreeMap insertions + n ceiling lookups |
| Space | O(n) — TreeMap |
