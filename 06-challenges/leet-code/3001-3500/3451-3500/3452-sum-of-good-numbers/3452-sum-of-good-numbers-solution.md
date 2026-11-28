# 3452. Sum of Good Numbers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sum-of-good-numbers/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** For each element, check if the neighbors at distance k (if they exist) are strictly smaller. Sum up all qualifying elements.

**Algorithm:**
1. Iterate over each index i in nums.
2. Check if nums[i] > nums[i-k] (if i-k >= 0) and nums[i] > nums[i+k] (if i+k < n).
3. If both conditions hold (or the neighbor doesn't exist), add nums[i] to the sum.
4. Return the total sum.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
