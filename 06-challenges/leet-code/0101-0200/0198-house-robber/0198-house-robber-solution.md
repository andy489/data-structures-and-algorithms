# 198. House Robber — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/house-robber/

---

## Solution 1: DP — O(n) time, O(1) space

**Idea:** At each house, the best we can do is the maximum of: (a) skipping this house (take whatever we had up to the previous house) or (b) robbing this house (take its value plus the best we could do two houses ago). We only ever need the last two dp values, so we keep two variables instead of an array.

**Algorithm:**
1. Maintain `prev2` (best up to `i-2`) and `prev1` (best up to `i-1`), both starting at 0.
2. For each `num` in `nums`:
   - `curr = max(prev1, prev2 + num)`
   - Shift: `prev2 = prev1`, `prev1 = curr`
3. Return `prev1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — two variables |

---

## Solution 2: DP array — O(n) time, O(n) space

**Idea:** Same recurrence `dp[i] = max(dp[i-1], dp[i-2] + nums[i])`, but stored in a full array for clarity.

**Algorithm:**
1. `dp[0] = nums[0]`, `dp[1] = max(nums[0], nums[1])`.
2. For `i` from 2 to `n-1`: `dp[i] = max(dp[i-1], dp[i-2] + nums[i])`.
3. Return `dp[n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — dp array |
