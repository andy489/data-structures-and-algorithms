# 1775. Equal Sum Arrays With Minimum Number of Operations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/equal-sum-arrays-with-minimum-number-of-operations/

---

## Solution: Greedy with Gain Counts — O(n + m) time, O(1) space

**Idea:** Compute the difference `diff = sum1 - sum2`. If positive, reduce `nums1` or increase `nums2`; if negative, do the opposite. Collect all possible gains (how much each element can contribute to closing the gap) into a frequency array of size 6, then greedily apply the largest gains first.

**Algorithm:**
1. Compute `sum1`, `sum2`. If `sum1 == sum2`, return 0.
2. Check if equalization is impossible: `min(nums1) * len2 > max(nums2) * len1` (or similar). More precisely: if `min_possible_sum1 > max_possible_sum2` or vice versa.
3. Ensure `sum1 >= sum2` (swap if needed, negate diff). Now we need to decrease `sum1 - sum2`.
4. Build `gains[1..5]`: for each element in `nums1`, gain = `val - 1`; for each in `nums2`, gain = `6 - val`. Sort all gains descending.
5. Greedily subtract gains until `diff <= 0`, counting operations.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — building gain counts; bucket sort over 6 values |
| Space | O(1) — fixed-size gain array of 6 |
