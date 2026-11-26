# 435. Non-overlapping Intervals — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/non-overlapping-intervals/

---

## Solution: Greedy (Earliest End Time) — O(n log n) time, O(1) space

**Idea:** Equivalent to finding the maximum number of non-overlapping intervals (the classic activity selection problem), then returning n minus that count. Sort by end time and greedily keep intervals that don't overlap with the last kept interval.

**Algorithm:**
1. Sort intervals by end time.
2. Track `end` = end of last kept interval (initially -∞).
3. For each interval: if its start >= `end`, keep it (update `end`); otherwise remove it (increment counter).
4. Return removed count.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting dominates |
| Space | O(1) — constant extra space (excluding sort) |
