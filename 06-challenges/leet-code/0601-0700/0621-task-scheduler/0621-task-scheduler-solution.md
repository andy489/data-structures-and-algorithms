# 621. Task Scheduler — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/task-scheduler/

---

## Solution: Math/Greedy — O(n) time, O(1) space

**Idea:** Let `maxFreq` be the highest task frequency and `maxCount` be the number of tasks with that frequency. The minimum time is either `tasks.length` (if tasks fill all slots) or the frame formula: `(maxFreq - 1) * (n + 1) + maxCount`.

**Algorithm:**
1. Count frequencies of each task.
2. Find `maxFreq` and count how many tasks share it.
3. Return `max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — count tasks |
| Space | O(1) — fixed 26-letter array |
