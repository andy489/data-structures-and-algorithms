# 1793. Maximum Score of a Good Subarray — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-score-of-a-good-subarray/

---

## Solution: Two-Pointer Shrink — O(n) time, O(1) space

**Idea:** Start with the window `[k, k]` and expand outward. At each step, greedily extend the side (left or right) that has the larger value, because this maximizes the minimum. Track the running minimum and update the best score. We must keep `k` inside the window, so expand left as long as `i > 0` and right as long as `j < n-1`.

**Algorithm:**
1. Initialize `i = k`, `j = k`, `minVal = nums[k]`, `ans = nums[k]`.
2. While `i > 0` or `j < n-1`:
   - If `i == 0`: expand right (`j++`).
   - Else if `j == n-1`: expand left (`i--`).
   - Else if `nums[i-1] >= nums[j+1]`: expand left (`i--`).
   - Else: expand right (`j++`).
   - Update `minVal = min(minVal, nums[i], nums[j])`.
   - Update `ans = max(ans, minVal * (j - i + 1))`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each index visited once |
| Space | O(1) — constant extra space |
