# 1509. Minimum Difference Between Largest and Smallest Value in Three Moves — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

---

## Solution: Sort and Enumerate Removal Patterns — O(n log n) time, O(1) space

**Idea:** After sorting, we want to remove three elements from the ends to minimize `max - min`. There are 4 ways to remove 3 from the extremes: remove 3 from the left, 2 from the left and 1 from the right, 1 from the left and 2 from the right, or 3 from the right. After removal the min is `nums[i]` and max is `nums[n-1-(3-i)]` for `i` in 0..3.

**Algorithm:**
1. If `n <= 4`, return 0 (we can remove everything that matters).
2. Sort `nums`.
3. Try the 4 removal patterns: `i` elements from the left, `3-i` from the right, for `i` in `{0,1,2,3}`.
4. For each, `diff = nums[n-1-(3-i)] - nums[i]`.
5. Return the minimum diff.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting dominates |
| Space | O(1) — sort in-place |
