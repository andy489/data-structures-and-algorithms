# 798. Smallest Rotation with Highest Score — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-rotation-with-highest-score/

---

## Solution: Difference Array — O(n) time, O(n) space

**Idea:** For each element `nums[i]`, find the range of k values for which it does NOT score a point, and mark a -1 in a difference array. Then use prefix sums to find which k gives the max score.

For element `nums[i]` at original position `i`, after rotation by k, its new position is `(i - k + n) % n`. It scores a point when `nums[i] <= (i - k + n) % n`, i.e., when it does NOT score only for k in a certain range.

**Algorithm:**
1. Start with score n (all points). Use difference array `change`.
2. For each i: compute bad_lo, bad_hi range where element loses a point; mark -1.
3. Compute prefix sum; argmax gives the answer.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — difference array |
