# 15. 3Sum — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/3sum/

---

## Solution

### Sort + Two Pointers — O(n²) time, O(log n) space

**Idea:** Fix one element and reduce the problem to finding a two-sum with the remaining elements. Sorting enables both the two-pointer technique and easy duplicate skipping.

**Algorithm:**
1. Sort `nums`.
2. For each index `i` from 0 to n-3:
   - **Skip duplicates:** if `nums[i] == nums[i-1]`, continue.
   - Set `left = i + 1`, `right = n - 1`.
   - While `left < right`:
     - `sum = nums[i] + nums[left] + nums[right]`
     - If `sum == 0`: record the triplet, then advance `left` and retreat `right` while skipping duplicates.
     - If `sum < 0`: `left++` (need a larger value).
     - If `sum > 0`: `right--` (need a smaller value).

**Why sorting enables duplicate skipping:** After sorting, equal values are adjacent. By skipping repeated values of the anchor `i`, and skipping repeated `left`/`right` after finding a valid triplet, we avoid producing the same triplet twice without using a set.

**Early termination:** If `nums[i] > 0`, no triplet can sum to 0 (all remaining values are ≥ nums[i] > 0), so we break.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — O(n log n) sort + O(n²) main loop |
| Space | O(log n) to O(n) — sorting in-place uses stack space |
