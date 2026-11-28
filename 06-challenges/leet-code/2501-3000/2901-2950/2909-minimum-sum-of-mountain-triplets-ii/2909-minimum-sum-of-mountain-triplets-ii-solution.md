# 2909. Minimum Sum of Mountain Triplets II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-sum-of-mountain-triplets-ii/

---

## Solution: Prefix/Suffix Min Arrays — O(n) time, O(n) space

**Idea:** Precompute `leftMin[j]` = minimum of `nums[0..j-1]` and `rightMin[j]` = minimum of `nums[j+1..n-1]`. For each `j`, if `leftMin[j] < nums[j]` and `rightMin[j] < nums[j]`, then the minimum triplet sum through `j` is `leftMin[j] + nums[j] + rightMin[j]`.

**Algorithm:**
1. Compute `leftMin[j]` = min of `nums[0..j-1]` for each `j`.
2. Compute `rightMin[j]` = min of `nums[j+1..n-1]` for each `j`.
3. For each `j` from 1 to n-2, if `leftMin[j] < nums[j]` and `rightMin[j] < nums[j]`, update answer.
4. Return minimum found or `-1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
