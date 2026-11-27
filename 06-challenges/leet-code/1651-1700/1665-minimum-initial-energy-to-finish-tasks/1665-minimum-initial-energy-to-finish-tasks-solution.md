# 1665. Minimum Initial Energy to Finish Tasks — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/

---

## Solution: Greedy with Sorting — O(n log n) time, O(1) space

**Idea:** To minimize initial energy, choose an optimal ordering. For two tasks A and B, task A should come before B if doing A first requires less total initial energy than doing B first. Comparing:
- A before B: need `max(minA, actual_A + minB)`
- B before A: need `max(minB, actual_B + minA)`

After simplification, A should come before B when `minA - actualA < minB - actualB` (i.e., sort by `minimum - actual` ascending, meaning higher "buffer" tasks go last).

**Algorithm:**
1. Sort tasks by `(minimum - actual)` in ascending order.
2. Simulate: track current energy. The minimum initial energy is determined greedily.
3. Scan from right, accumulating required energy.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) extra |
