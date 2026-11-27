# 1679. Max Number of K-Sum Pairs — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/max-number-of-k-sum-pairs/

---

## Solution: Two Pointers on Sorted Array — O(n log n) time, O(1) space

**Idea:** Sort the array. Use two pointers from both ends. If sum equals `k`, count a pair and move both pointers inward. If sum < k, move left pointer right. If sum > k, move right pointer left.

**Algorithm:**
1. Sort `nums`.
2. Set `l = 0, r = n - 1, count = 0`.
3. While `l < r`: if `nums[l] + nums[r] == k`, increment count, l++, r--. Else if sum < k, l++. Else r--.
4. Return count.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) extra |
