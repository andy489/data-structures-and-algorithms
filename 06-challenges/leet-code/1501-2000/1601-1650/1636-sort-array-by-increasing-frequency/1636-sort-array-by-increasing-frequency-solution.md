# 1636. Sort Array by Increasing Frequency — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sort-array-by-increasing-frequency/

---

## Solution: Frequency Map + Custom Sort — O(n log n) time, O(n) space

**Idea:** Count the frequency of each value, then sort by (frequency ascending, value descending) as a tiebreaker.

**Algorithm:**
1. Build a frequency map of all values.
2. Sort `nums` with a comparator: primary key = frequency ascending; secondary key = value descending.
3. Return the sorted array.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting dominates |
| Space | O(n) — frequency map |
