# 1994. The Number of Good Subsets

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/the-number-of-good-subsets/

## Description

You are given an integer array `nums`. We call a subset of `nums` good if its product can be represented as a product of one or more distinct prime numbers.

Return the number of different good subsets in `nums` modulo `10^9 + 7`.

A subset of `nums` is any array that can be obtained by deleting some (possibly none or all) elements from `nums`. Two subsets are different if and only if the chosen indices to delete are different.

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4]
Output: 6
Explanation: The good subsets are:
- [1,2]: product is 2 = 2
- [1,2,3]: product is 6 = 2*3
- [1,3]: product is 3 = 3
- [2]: product is 2 = 2
- [2,3]: product is 6 = 2*3
- [3]: product is 3 = 3
```

**Example 2:**
```
Input: nums = [4,2,3,15]
Output: 5
Explanation: The good subsets are:
- [2]: product is 2
- [2,3]: product is 6 = 2*3
- [2,15]: product is 30 = 2*3*5
- [3]: product is 3
- [15]: product is 15 = 3*5
```

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 30`
