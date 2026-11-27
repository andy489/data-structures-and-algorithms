# 1099. Two Sum Less Than K — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/two-sum-less-than-k/

---

## Solution: Sort + Two Pointers — O(n log n) time, O(1) space

**Idea:** Sort and use two pointers. If sum < k, update best and move left pointer right. If sum >= k, move right pointer left.

**Algorithm:**
1. Sort nums.
2. Two pointers l=0, r=n-1. While l<r: sum = nums[l]+nums[r]. If sum < k, best = max(best, sum), l++. Else r--.
3. Return best.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
