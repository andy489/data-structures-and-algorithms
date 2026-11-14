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

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — one variable |
