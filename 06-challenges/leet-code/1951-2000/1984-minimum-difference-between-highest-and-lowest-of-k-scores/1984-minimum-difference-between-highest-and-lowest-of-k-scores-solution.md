# 1984. Minimum Difference Between Highest and Lowest of K Scores — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/

---

## Solution: Sorting + Sliding Window — O(n log n) time, O(1) space

**Idea:** Sort the array. The optimal `k` scores to pick are always contiguous in sorted order (to minimize max - min). Slide a window of size `k` and track the minimum difference.

**Algorithm:**
1. Sort `nums`.
2. For each window `[i, i+k-1]`, compute `nums[i+k-1] - nums[i]`.
3. Return the minimum.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
