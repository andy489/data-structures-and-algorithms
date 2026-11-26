# 3066. Minimum Operations To Exceed Threshold Value Ii — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

---

## Solution: Min-Heap (Priority Queue) — O(n log n) time, O(n) space

**Idea:** Use a min-heap to always extract the two smallest elements efficiently.

**Algorithm:**
1. Add all elements to a min-heap.
2. While heap's minimum < k: extract x and y (two smallest), add min(x,y)*2+max(x,y) back, increment ops.
3. Return ops.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — O(n log n) — heap ops |
| Space | O(n) — O(n) — heap |
