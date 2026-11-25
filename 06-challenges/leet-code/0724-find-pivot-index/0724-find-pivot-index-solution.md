# 724. Find Pivot Index — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-pivot-index/

---

## Solution: Prefix Sum — O(n) time, O(1) space

**Idea:** Compute total sum. Maintain a running left sum. At each index, right sum = total - leftSum - nums[i]. If leftSum == rightSum, return index.

**Algorithm:**
1. Compute `total = sum(nums)`.
2. Init `leftSum = 0`.
3. For each i: if `leftSum == total - leftSum - nums[i]`, return i.
4. Add `nums[i]` to `leftSum`.
5. Return -1.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
