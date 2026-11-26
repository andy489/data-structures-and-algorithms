# 3411. Maximum Subarray With Equal Products — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-subarray-with-equal-products/

---

## Solution: Brute-Force Sliding Window — O(n² log M) time, O(1) space

**Idea:** Since `nums[i] <= 10` and `nums.length <= 100`, the product can overflow fast — but we only need to check the condition `prod == lcm * gcd`. Enumerate every subarray, maintaining running `prod`, `gcd`, and `lcm`. As soon as `prod` overflows (exceeds `lcm * gcd` could never catch up), break early.

**Algorithm:**
1. For each start index `i`, reset `prod = gcd = lcm = nums[i]`.
2. Extend right to `j`, updating `prod *= nums[j]`, `gcd = gcd(gcd, nums[j])`, `lcm = lcm(lcm, nums[j])`.
3. If `prod == lcm * gcd`, update answer with `j - i + 1`.
4. If `prod > lcm * gcd` (product grows faster), break (further extension only widens gap).

**Complexity:**

| | |
|---|---|
| Time | O(n² log M) — n² subarrays, each gcd/lcm update is O(log M) |
| Space | O(1) |
