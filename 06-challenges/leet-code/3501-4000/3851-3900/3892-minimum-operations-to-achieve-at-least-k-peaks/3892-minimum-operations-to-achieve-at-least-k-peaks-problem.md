# 3892. Minimum Operations to Achieve At Least K Peaks

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-operations-to-achieve-at-least-k-peaks/

## Problem Statement

You are given a circular integer array `nums` of length `n`.

An index `i` is a **peak** if its value is **strictly greater** than its neighbors:

- The **previous** neighbor of `i` is `nums[i - 1]` if `i > 0`, otherwise `nums[n - 1]`.
- The **next** neighbor of `i` is `nums[i + 1]` if `i < n - 1`, otherwise `nums[0]`.

You are allowed to perform the following operation **any** number of times:

- Choose any index `i` and **increase** `nums[i]` by 1.

Return an integer denoting the **minimum** number of operations required to make the array contain **at least** `k` peaks. If it is impossible, return -1.

## Examples

### Example 1
**Input:** `nums = [2,1,2], k = 1`
**Output:** `1`

**Explanation:** Increase `nums[2] = 2` to 3. After this, `nums[2] = 3` is strictly greater than neighbors `nums[0] = 2` and `nums[1] = 1`.

### Example 2
**Input:** `nums = [4,5,3,6], k = 2`
**Output:** `0`

**Explanation:** The array already contains at least k=2 peaks.

### Example 3
**Input:** `nums = [3,7,3], k = 2`
**Output:** `-1`

**Explanation:** It is impossible to have at least k=2 peaks.

## Constraints

- `2 <= n == nums.length <= 5000`
- `-10^5 <= nums[i] <= 10^5`
- `0 <= k <= n`
