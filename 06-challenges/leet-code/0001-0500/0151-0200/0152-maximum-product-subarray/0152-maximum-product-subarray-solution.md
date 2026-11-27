# 152. Maximum Product Subarray — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-product-subarray/

---

## Solution 1: Track Max and Min — O(n) time, O(1) space

**Idea:** A negative number can flip the minimum product to the maximum and vice versa. Track both `curMax` and `curMin` at every step. Reset to the current element when the running product is worse than starting fresh.

**Algorithm:**
1. Init `curMax = curMin = result = nums[0]`.
2. For each subsequent element `n`:
   - Candidates: `n`, `curMax * n`, `curMin * n`.
   - `curMax = max(candidates)`, `curMin = min(candidates)`.
   - `result = max(result, curMax)`.
3. Return `result`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — three rolling variables |

---

## Solution 2: Forward + Backward Pass — O(n) time, O(1) space

**Idea:** Any zero resets the product. Run one forward pass (prefix products) and one backward pass (suffix products), tracking the max. This handles zeros naturally.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
