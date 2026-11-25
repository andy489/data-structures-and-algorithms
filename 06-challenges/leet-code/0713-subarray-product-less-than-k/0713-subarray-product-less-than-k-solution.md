# 713. Subarray Product Less Than K — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/subarray-product-less-than-k/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Use a sliding window [lo, hi]. Expand hi each step; if product >= k, shrink from lo. All subarrays ending at hi and starting at lo..hi are valid — there are `hi - lo + 1` of them.

**Algorithm:**
1. If k <= 1, return 0 (product of positive integers can't be < 1 except empty).
2. Initialize `lo = 0`, `product = 1`, `count = 0`.
3. For each `hi`: multiply product by `nums[hi]`. While product >= k, divide by `nums[lo++]`.
4. Add `hi - lo + 1` to count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each pointer moves at most n steps |
| Space | O(1) |
