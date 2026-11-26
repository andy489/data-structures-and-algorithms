# 2012. Sum of Beauty in the Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-beauty-in-the-array/

---

## Solution: Prefix Max / Suffix Min — O(n) time, O(n) space

**Idea:** Precompute prefix max and suffix min arrays. For each middle index check beauty 2 then 1.

**Algorithm:**
1. Build `prefMax[i]` = max of `nums[0..i]`.
2. Build `sufMin[i]` = min of `nums[i..n-1]`.
3. For each `i` in [1, n-2]: beauty 2 if `prefMax[i-1] < nums[i] < sufMin[i+1]`, else 1 if `nums[i-1] < nums[i] < nums[i+1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
