# 2007. Find Original Array From Doubled Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-original-array-from-doubled-array/

---

## Solution: Sort and Greedy — O(n log n) time, O(n) space

**Idea:** Sort `changed`. Greedily pair each smallest unpaired element with its double.

**Algorithm:**
1. Sort `changed`.
2. Use a frequency map.
3. For each element in sorted order, if its count > 0, pair it with `2 * element`; if `2 * element` not available, return `[]`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
