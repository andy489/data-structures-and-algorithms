# 3911. K-th Smallest Remaining Even Integer in Subarray Queries

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/k-th-smallest-remaining-even-integer-in-subarray-queries/

## Problem

You are given an integer array `nums` where `nums` is **strictly increasing**.

You are also given a 2D integer array `queries`, where `queries[i] = [l_i, r_i, k_i]`.

For each query `[l_i, r_i, k_i]`:
- Consider the **subarray** `nums[l_i..r_i]`
- From the **infinite** sequence of all **positive even integers**: `2, 4, 6, 8, 10, 12, 14, ...`
- **Remove** all elements that appear in the **subarray** `nums[l_i..r_i]`.
- Find the `k_i`-th **smallest integer** remaining in the sequence after the removals.

Return an integer array `ans`, where `ans[i]` is the result for the `i`-th query.

## Examples

**Example 1:**
```
Input: nums = [1,4,7], queries = [[0,2,1],[1,1,2],[0,0,3]]
Output: [2,6,6]
```

**Example 2:**
```
Input: nums = [2,4,6], queries = [[0,2,1]]
Output: [8]
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `nums` is strictly increasing.
- `1 <= queries.length <= 10^5`
- `queries[i] = [l_i, r_i, k_i]`
- `0 <= l_i <= r_i < nums.length`
- `1 <= k_i <= 10^9`
