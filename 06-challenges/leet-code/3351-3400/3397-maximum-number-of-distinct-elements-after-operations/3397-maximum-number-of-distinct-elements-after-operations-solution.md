# 3397. Maximum Number of Distinct Elements After Operations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/

---

## Solution: Greedy Sort — O(n log n) time, O(1) space

**Idea:** Sort the array and greedily assign each element the smallest available value within its allowed range `[nums[i] - k, nums[i] + k]`. Track the last assigned value (`prev`). For each element, the best we can do is assign `max(nums[i] - k, prev + 1)`. If that value exceeds `nums[i] + k`, we cannot assign a new distinct value for this element.

**Algorithm:**
1. Sort `nums`.
2. Set `prev = Integer.MIN_VALUE`, `count = 0`.
3. For each `nums[i]`:
   - Candidate = `max(nums[i] - k, prev + 1)`.
   - If `candidate <= nums[i] + k`, assign it: `prev = candidate`, `count++`.
4. Return `count`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting |
| Space | O(1) — in-place sort |
