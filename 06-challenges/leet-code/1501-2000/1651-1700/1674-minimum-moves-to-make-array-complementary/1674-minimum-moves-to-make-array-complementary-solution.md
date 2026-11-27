# 1674. Minimum Moves to Make Array Complementary — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-moves-to-make-array-complementary/

---

## Solution: Difference Array — O(n + limit) time, O(limit) space

**Idea:** For each pair `(a, b)` = `(nums[i], nums[n-1-i])`, any target sum `T` in `[2, 2*limit]` costs:
- 0 moves if `T == a + b`
- 1 move if `min(a,b)+1 <= T <= max(a,b)+limit` (change one element)
- 2 moves otherwise

Use a difference array `diff[2..2*limit+1]` to record where the cost changes.

**Algorithm:**
1. For each pair, add delta changes to the difference array.
2. Accumulate prefix sums and find the minimum cost.

**Complexity:**

| | |
|---|---|
| Time | O(n + limit) |
| Space | O(limit) |
