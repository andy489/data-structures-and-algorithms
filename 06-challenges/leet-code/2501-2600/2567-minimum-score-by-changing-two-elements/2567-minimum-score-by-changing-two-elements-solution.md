# 2567. Minimum Score by Changing Two Elements — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-score-by-changing-two-elements/

---

## Solution: Sort + Four-Case Minimum — O(n log n) time, O(1) space

**Idea:** The low score (min pair difference) can always be driven to 0 by setting two changed elements equal to any value. So the total score equals just the high score (max pair difference = range of sorted array). We need to minimize the range after removing at most 2 elements from the extremes — which is equivalent to changing those 2 elements to anything inside the range.

After sorting, the range is `nums[n-1] - nums[0]`. Changing 2 elements optimally means we "cut" up to 2 endpoints off the sorted array. There are exactly four cases depending on how many we cut from each end:

| Cut from left | Cut from right | New range |
|---|---|---|
| 0 | 2 | `nums[n-3] - nums[0]` |
| 1 | 1 | `nums[n-2] - nums[1]` |
| 2 | 0 | `nums[n-1] - nums[2]` |
| 2 | 2 | `0` (possible only if n ≤ 4, reduces to same formula) |

The answer is the minimum of these four values.

**Algorithm:**
1. Sort `nums`.
2. Return `min(nums[n-3] - nums[0], nums[n-2] - nums[1], nums[n-1] - nums[2])`.

Note: the fourth case (cut 2 from each end) would leave at most 1 element when `n = 3`, giving range 0, which is already captured because `nums[0] - nums[0] = 0` holds for the first formula when all three are equal. For `n >= 4` it equals cutting 2 from one side, so the minimum of the three formulas above covers all cases.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting dominates |
| Space | O(1) — sort in-place, three index reads |
