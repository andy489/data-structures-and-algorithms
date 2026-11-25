# 665. Non-decreasing Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/non-decreasing-array/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** Count violations. On first violation at index `i` where `nums[i] > nums[i+1]`, greedily decide: lower `nums[i]` to `nums[i-1]` if possible, otherwise raise `nums[i+1]` to `nums[i]`. If a second violation occurs, return false.

**Algorithm:**
1. Scan for violations (nums[i] > nums[i+1]).
2. On first violation: if `i > 0 && nums[i-1] > nums[i+1]`, set `nums[i+1] = nums[i]`; else set `nums[i] = nums[i-1]` (or just lower nums[i]).
3. Track count; if count > 1 return false.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
