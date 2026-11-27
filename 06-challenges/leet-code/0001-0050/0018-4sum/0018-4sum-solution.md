# 18. 4Sum — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/4sum/

---

## Solution

### Sort + Two Pointers — O(n³) time, O(log n) space

**Idea:** Generalize 3Sum by fixing one more element with an outer loop, then reduce the inner problem to 3Sum (fix second element + two pointers).

**Algorithm:**
1. Sort `nums`.
2. For each index `i` from 0 to n-4:
   - **Skip duplicates:** if `nums[i] == nums[i-1]`, continue.
   - For each index `j` from `i+1` to n-3:
     - **Skip duplicates:** if `nums[j] == nums[j-1]` (and `j > i+1`), continue.
     - Set `left = j + 1`, `right = n - 1`.
     - While `left < right`:
       - `sum = nums[i] + nums[j] + nums[left] + nums[right]`
       - If `sum == target`: record the quadruplet, then advance `left` and retreat `right` while skipping duplicates.
       - If `sum < target`: `left++`.
       - If `sum > target`: `right--`.

**Why it works:** Sorting keeps equal values adjacent, enabling the same duplicate-skipping technique as 3Sum at every level.

**Complexity:**

| | |
|---|---|
| Time | O(n³) — O(n log n) sort + O(n³) main loop |
| Space | O(log n) to O(n) — sorting in-place uses stack space |
