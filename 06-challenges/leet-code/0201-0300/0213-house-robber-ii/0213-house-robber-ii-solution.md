# 213. House Robber II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/house-robber-ii/

---

## Solution: Two Linear DP Passes — O(n) time, O(1) space

**Idea:** Because the first and last house are adjacent, we cannot rob both. Break the circle by solving the linear House Robber problem twice: once for `nums[0..n-2]` (skip last) and once for `nums[1..n-1]` (skip first). Return the max of the two.

**Algorithm:**
1. Handle edge case: if `n == 1` return `nums[0]`.
2. `rob(start, end)`: standard linear DP with two variables `prev2` and `prev1`.
3. Return `max(rob(0, n-2), rob(1, n-1))`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear passes |
| Space | O(1) — constant extra space |
