# 2054. Two Best Non-Overlapping Events — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/two-best-non-overlapping-events/

---

## Solution: Sort + Binary Search + Prefix Max — O(n log n) time, O(n) space

**Idea:** Sort by end time. For each event as 2nd event, binary search for best non-overlapping 1st event.

**Algorithm:**
1. Sort events by end time.
2. Build prefix max of values.
3. For each event as 2nd, binary search for rightmost event ending before this starts.
4. Max(value_i, prefix_max[j] + value_i).

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
