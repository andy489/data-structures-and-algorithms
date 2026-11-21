# 134. Gas Station — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/gas-station/

---

## Solution: Greedy Single Pass — O(n) time, O(1) space

**Idea:** If the total gas surplus (`sum(gas) - sum(cost)`) is negative, no solution exists. Otherwise a solution is guaranteed to exist and is unique. To find it: scan left to right, maintaining `tank` (running surplus from the current candidate start). When `tank` drops below 0, the current start and every station between it and `i` cannot be the answer (they all inherit the deficit), so reset the candidate start to `i + 1` and clear `tank`. The last candidate standing is the answer.

**Algorithm:**
1. Initialize `total = 0`, `tank = 0`, `start = 0`.
2. For each station `i`:
   - `diff = gas[i] - cost[i]`
   - `total += diff`, `tank += diff`
   - If `tank < 0`: set `start = i + 1`, reset `tank = 0`.
3. Return `start` if `total >= 0`, else `-1`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — single pass |
| Space | O(1) — three integer variables |
