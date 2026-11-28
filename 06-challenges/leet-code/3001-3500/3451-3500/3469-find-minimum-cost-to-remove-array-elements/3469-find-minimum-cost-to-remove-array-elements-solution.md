# 3469. Find Minimum Cost to Remove Array Elements — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-minimum-cost-to-remove-array-elements/

---

## Solution: Dynamic Programming — O(n^2) time, O(n) space

**Idea:** At each step we choose 2 from the first 3 elements to remove (cost = max of two), or if < 3 remain, remove all (cost = max). Use DP where the state is the current index and the one element "carried over" from previous operations.

**Algorithm:**
1. dp[i][carry] = minimum cost to remove all elements from index i onward, given one element `carry` from the previous round (or -1 if none).
2. At each step, if we have carry + nums[i] + nums[i+1] available as first 3, pick 2 to remove (the ones that minimize cost = max of two).
3. The optimal strategy: always remove the max element together with as small as possible, keeping smaller elements for later.
4. Recurse or iterate with memoization.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
