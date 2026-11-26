# 630. Course Schedule III — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/course-schedule-iii/

---

## Solution: Greedy + Max Heap — O(n log n) time, O(n) space

**Idea:** Sort courses by deadline. Greedily take each course. If taking it would exceed its deadline, replace the longest course taken so far (if it's longer than current) to free up time.

**Algorithm:**
1. Sort by `lastDay` ascending.
2. Maintain a max-heap of durations taken so far; track `time`.
3. For each course: add duration to time, push to heap.
4. If `time > lastDay`, pop the max (longest course) and subtract from time.
5. Heap size at end is the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sort + heap operations |
| Space | O(n) — heap |
