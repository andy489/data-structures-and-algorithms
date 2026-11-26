# 871. Minimum Number of Refueling Stops — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-refueling-stops/

---

## Solution: Greedy with Max-Heap — O(n log n) time, O(n) space

**Idea:** Greedily, when fuel runs out, pick the largest fuel amount from all previously passed stations (using a max-heap). This minimizes refueling stops.

**Algorithm:**
1. Use max-heap to track available fuel at passed stations.
2. Iterate through stations (append target as final station).
3. If can reach next station: add its fuel to heap.
4. If can't reach: pop from heap (refuel) until can reach or heap empty.
5. Count refuels; return -1 if heap exhausted.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
