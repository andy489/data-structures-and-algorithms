# 3919. Minimum Cost to Move Between Indices

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/minimum-cost-to-move-between-indices/

## Problem

You are given an integer array `nums` where `nums` is **strictly increasing**.

For each index `x`, let `closest(x)` be the **adjacent** index `y` such that `abs(nums[x] - nums[y])` is **minimized**. If both **adjacent** indices exist and give the same difference, choose the **smaller** index.

From any index `x`, you can move in two ways:
- To any index `y` with cost `abs(nums[x] - nums[y])`, or
- To `closest(x)` with cost 1.

You are also given a 2D integer array `queries`, where each `queries[i] = [l_i, r_i]`.

For each query, calculate the **minimum total cost** to move from index `l_i` to index `r_i`.

Return an integer array `ans`, where `ans[i]` is the answer for the `i`-th query.

## Examples

**Example 1:**
```
Input: nums = [-5,-2,3], queries = [[0,2],[2,0],[1,2]]
Output: [6,2,5]

Explanation:
- closest indices are [1, 0, 1] respectively.
- For [0,2]: path 0->1->2 costs 1 + |-2-3| = 1+5 = 6.
- For [2,0]: path 2->1->0 costs 1+1 = 2 (closest moves).
- For [1,2]: direct move |-2-3| = 5.
```

**Example 2:**
```
Input: nums = [0,2,3,9], queries = [[3,0],[1,2],[2,0]]
Output: [4,1,3]
```

## Constraints

- `2 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`
- `nums` is strictly increasing.
- `1 <= queries.length <= 10^4`
- `queries[i].length == 2`
- `0 <= l_i, r_i < nums.length`
