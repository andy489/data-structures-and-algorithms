# 698. Partition to K Equal Sum Subsets — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

---

## Solution: Backtracking — O(k·2^n) time, O(n) space

**Idea:** Sort descending, fill k buckets each of target = sum/k. Prune when bucket sum would exceed target or current number is too large.

**Algorithm:**
1. Check sum divisible by k.
2. Sort descending; if nums[0] > target, return false.
3. Backtrack: try placing nums[idx] in each bucket. Skip duplicate bucket sums to avoid redundant states.

**Complexity:**

| | |
|---|---|
| Time | O(k·2^n) — in practice much faster with pruning |
| Space | O(n) — recursion + bucket array |
