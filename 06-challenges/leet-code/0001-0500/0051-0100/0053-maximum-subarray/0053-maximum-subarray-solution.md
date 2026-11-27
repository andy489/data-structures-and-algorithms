# 53. Maximum Subarray — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-subarray/

---

## Solution: Kadane's Algorithm — O(n) time, O(1) space

**Idea:** At each index, the maximum subarray ending here is either the current element alone (start fresh) or the current element added to the best subarray ending at the previous index. Track the global maximum across all positions.

**Algorithm:**
1. Initialize `maxSum = nums[0]`, `curr = nums[0]`.
2. For each element from index `1`:
   - `curr = max(nums[i], curr + nums[i])` — extend or restart
   - `maxSum = max(maxSum, curr)`
3. Return `maxSum`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — two scalar variables |

---

## Solution 2: Divide and Conquer — O(n log n) time, O(log n) space

**Idea:** Split the array at the midpoint. The maximum subarray either lies entirely in the left half, entirely in the right half, or crosses the midpoint. The crossing case is solved in O(n) by expanding outward from mid.

**Algorithm:**
1. Base case: single element → return it.
2. `mid = (lo + hi) / 2`
3. `leftMax` = max subarray sum in `[lo, mid]` (recursive)
4. `rightMax` = max subarray sum in `[mid+1, hi]` (recursive)
5. `crossMax` = max suffix sum ending at `mid` + max prefix sum starting at `mid+1`
6. Return `max(leftMax, rightMax, crossMax)`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — T(n) = 2T(n/2) + O(n) |
| Space | O(log n) — recursion stack depth |
