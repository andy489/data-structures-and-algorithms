# 2104. Sum of Subarray Ranges — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/sum-of-subarray-ranges/

---

## Solution: Brute Force — O(n^2) time, O(1) space

**Idea:** For each starting index `i`, expand the subarray to the right, maintaining the current min and max. Add `max - min` for each subarray.

**Algorithm:**
1. For each `i` from `0` to `n-1`:
2. Initialize `curMin = curMax = nums[i]`.
3. For each `j` from `i+1` to `n-1`:
   - Update `curMin = min(curMin, nums[j])`, `curMax = max(curMax, nums[j])`.
   - Add `curMax - curMin` to the answer.
4. Return the total sum.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — all pairs (i, j) |
| Space | O(1) — no extra storage |

---

## Solution 2: Monotonic Stack — O(n) time, O(n) space

**Idea:** `sum of ranges = sum of subarray maxima - sum of subarray minima`. Each can be computed in O(n) using monotonic stacks (contribution technique).

For sum of subarray maxima: for each element `nums[i]`, find how many subarrays have `nums[i]` as their maximum by computing `left[i]` (distance to previous greater element) and `right[i]` (distance to next greater-or-equal element). Contribution = `nums[i] * left[i] * right[i]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two monotonic stack passes |
| Space | O(n) — stack storage |
