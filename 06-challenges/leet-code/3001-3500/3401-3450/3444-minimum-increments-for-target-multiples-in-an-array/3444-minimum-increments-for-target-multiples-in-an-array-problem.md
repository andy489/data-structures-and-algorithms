# 3444. Minimum Increments for Target Multiples in an Array

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-increments-for-target-multiples-in-an-array/

## Problem

You are given two arrays, nums and target.

In a single operation, you may increment any element of nums by 1.

Return the minimum number of operations required so that each element in target has at least one multiple in nums.

## Examples

**Example 1:**
```
Input: nums = [1,2,3], target = [4]
Output: 1
Explanation:
Increment 3 to 4 with just one operation, making 4 a multiple of itself.
```

**Example 2:**
```
Input: nums = [8,4], target = [10,5]
Output: 2
Explanation:
Increment 8 to 10 with 2 operations, making 10 a multiple of both 5 and 10.
```

**Example 3:**
```
Input: nums = [7,9,10], target = [7]
Output: 0
Explanation:
Target 7 already has a multiple in nums, so no additional operations are needed.
```

## Constraints

- 1 <= nums.length <= 5 * 10^4
- 1 <= target.length <= 4
- target.length <= nums.length
- 1 <= nums[i], target[i] <= 10^4
