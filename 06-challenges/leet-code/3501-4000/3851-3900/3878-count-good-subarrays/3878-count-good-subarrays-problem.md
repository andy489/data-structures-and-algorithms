# 3878. Count Good Subarrays

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-good-subarrays/

## Problem

You are given an integer array `nums`.

A **subarray** is called **good** if the **bitwise OR** of all its elements is equal to **at least one** element present in that subarray.

Return the number of good subarrays in `nums`.

## Examples

**Example 1:**
```
Input: nums = [4,2,3]
Output: 4
Explanation:
Subarray | OR  | Present?
[4]      | 4   | Yes
[2]      | 2   | Yes
[3]      | 3   | Yes
[4,2]    | 6   | No
[2,3]    | 3   | Yes
[4,2,3]  | 7   | No
Good subarrays: [4],[2],[3],[2,3] -> 4
```

**Example 2:**
```
Input: nums = [1,3,1]
Output: 6
Explanation:
All 6 subarrays are good since any subarray containing 3 has OR=3 (present), and subarrays with only 1 have OR=1 (present).
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
