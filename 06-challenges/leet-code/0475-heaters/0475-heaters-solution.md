# 475. Heaters — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/heaters/

---

## Solution: Sort + Binary Search — O((H + N) log N) time, O(1) space

**Idea:** For each house, binary-search the heaters array to find the nearest heater. The answer is the maximum of all these minimum distances.

**Algorithm:**
1. Sort heaters.
2. For each house, binary search to find insertion point; check neighbors (left and right heater).
3. Take min of distances to both neighbors; track overall max.

**Complexity:**

| | |
|---|---|
| Time | O((H + N) log N) — H houses × log N binary search |
| Space | O(1) — ignoring sort |
