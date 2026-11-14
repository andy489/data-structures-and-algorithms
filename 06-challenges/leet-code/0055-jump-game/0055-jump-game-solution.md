# 55. Jump Game — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/jump-game/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** Track the farthest index reachable so far (`maxReach`). At each position `i`, if `i > maxReach` we're stuck and return `false`; otherwise update `maxReach = max(maxReach, i + nums[i])`. If we finish the loop, the last index is reachable.

**Algorithm:**
1. Initialize `maxReach = 0`.
2. For each index `i` from `0` to `n-1`:
   - If `i > maxReach`, return `false`.
   - `maxReach = max(maxReach, i + nums[i])`
3. Return `true`.

---

## Solution 2: Greedy Right-to-Left — O(n) time, O(1) space

**Idea:** Start with `goal = n - 1` (the last index is trivially reachable from itself). Scan backwards: if `i + nums[i] >= goal`, index `i` can reach the current goal, so shift `goal = i`. After the scan, `goal == 0` iff the first index can reach the end.

**Algorithm:**
1. `goal = n - 1`
2. For `i` from `n-2` down to `0`:
   - If `i + nums[i] >= goal`: `goal = i`
3. Return `goal == 0`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single reverse pass |
| Space | O(1) — one variable |
