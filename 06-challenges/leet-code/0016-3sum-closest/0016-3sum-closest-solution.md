# 16. 3Sum Closest — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/3sum-closest/

---

## Solution

### Sort + Two Pointers — O(n²) time, O(log n) space

**Idea:** Identical in structure to 3Sum. Sort the array, fix one element, and use two pointers to scan the remaining pair. Track the closest sum seen.

**Algorithm:**
1. Sort `nums`.
2. Initialize `closest = nums[0] + nums[1] + nums[2]`.
3. For each index `i` from 0 to n-3:
   - `left = i + 1`, `right = n - 1`
   - While `left < right`:
     - `sum = nums[i] + nums[left] + nums[right]`
     - If `|sum - target| < |closest - target|`: update `closest = sum`.
     - If `sum < target`: `left++` (need a larger sum).
     - If `sum > target`: `right--` (need a smaller sum).
     - If `sum == target`: return immediately (can't get closer than 0 distance).
4. Return `closest`.

**Why two pointers work after sorting:** For a fixed `i`, as `left` increases the sum increases and as `right` decreases the sum decreases. This monotonicity means we can navigate toward `target` deterministically without checking all pairs.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — O(n log n) sort + O(n²) main loop |
| Space | O(log n) to O(n) — sorting in-place |
