# 1658. Minimum Operations to Reduce X to Zero — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

---

## Solution: Sliding Window (Longest Subarray with Target Sum) — O(n) time, O(1) space

**Idea:** Instead of minimizing operations from both ends, equivalently find the **longest subarray** with sum equal to `total - x`. The answer is then `n - len`.

**Algorithm:**
1. Compute `target = sum(nums) - x`. If `target < 0`, return -1.
2. Use a sliding window with two pointers `l, r`. Maintain `windowSum`.
3. Expand right, shrink left when `windowSum > target`. Track max length when `windowSum == target`.
4. Return `n - maxLen` if found, else -1.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) |
