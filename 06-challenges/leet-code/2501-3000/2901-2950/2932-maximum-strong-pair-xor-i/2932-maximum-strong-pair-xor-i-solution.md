# 2932. Maximum Strong Pair XOR I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-strong-pair-xor-i/

---

## Solution: Brute Force — O(n²) time, O(1) space

**Idea:** Since `n <= 50`, enumerate all pairs `(x, y)`, check whether they form a strong pair (`|x - y| <= min(x, y)`), and track the maximum XOR among valid pairs.

**Algorithm:**
1. Initialize `ans = 0`.
2. For each pair `(nums[i], nums[j])`:
   - If `|nums[i] - nums[j]| <= min(nums[i], nums[j])`, update `ans = max(ans, nums[i] XOR nums[j])`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(1) |
