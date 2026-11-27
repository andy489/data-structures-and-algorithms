# 632. Smallest Range Covering Elements from K Lists — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

---

## Solution: Min Heap + Max Tracker — O(n log k) time, O(k) space

**Idea:** Use a min heap initialized with the first element of each list. Track the current max. At each step, the range is [heap_min, current_max]. Advance the list that contributed the min element to get a potentially smaller range.

**Algorithm:**
1. Push (val, listIdx, elemIdx) for each list's first element.
2. Track currentMax = max of first elements.
3. While heap non-empty: record range [heap_min, currentMax] if smaller. Pop min; push next element from same list (update currentMax). If a list is exhausted, stop.

**Complexity:**

| | |
|---|---|
| Time | O(n log k) — n total elements, heap size k |
| Space | O(k) — heap |
