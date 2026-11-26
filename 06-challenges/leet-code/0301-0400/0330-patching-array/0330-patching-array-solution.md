# 330. Patching Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/patching-array/

---

## Solution: Greedy Range Extension — O(m + log n) time, O(1) space

**Idea:** Maintain `reach` = maximum sum reachable so far. If `nums[i] <= reach + 1`, extend reach. Otherwise must patch with `reach + 1`.

**Algorithm:**
1. Init `reach = 0`, `patches = 0`, `i = 0`.
2. While `reach < n`: if `nums[i] <= reach + 1`, extend `reach += nums[i++]`. Else `reach += reach + 1`, `patches++`.
3. Return `patches`.

**Complexity:**

| | |
|---|---|
| Time | O(m + log n) |
| Space | O(1) |
