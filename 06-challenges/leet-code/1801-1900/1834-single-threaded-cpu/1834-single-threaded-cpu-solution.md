# 1834. Single-Threaded CPU — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/single-threaded-cpu/

---

## Solution: Sort + Min-Heap — O(n log n) time, O(n) space

**Idea:** Sort tasks by enqueue time (keeping original indices). Use a min-heap ordered by (processingTime, originalIndex) to track available tasks. Simulate time: if the heap is empty, jump time to the next task's enqueue time. Otherwise pop the shortest task from the heap and advance time by its processing duration.

**Algorithm:**
1. Pair each task with its original index, then sort by enqueue time.
2. Initialize `time = 0`, `i = 0` (pointer into sorted tasks), min-heap `pq`.
3. While result not complete:
   - Enqueue all tasks with `enqueueTime <= time` into `pq`.
   - If `pq` is empty, jump `time` to next task's enqueue time and repeat enqueue step.
   - Poll from `pq` (min processingTime, then min index), add index to result, advance `time`.
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting and heap operations |
| Space | O(n) — heap and sorted array |
