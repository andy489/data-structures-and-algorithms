# 3909. Compare Sums of Bitonic Parts

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/compare-sums-of-bitonic-parts/

## Problem

You are given a **bitonic** array `nums` of length `n`.

Split the array into **two** parts:
- **Ascending part**: from index 0 to the peak element (inclusive).
- **Descending part**: from the peak element to index `n-1` (inclusive).

The peak element belongs to both parts.

Return:
- 0 if the sum of the **ascending** part is greater.
- 1 if the sum of the **descending** part is greater.
- -1 if both sums are **equal**.

**Notes:**
- A **bitonic** array is an array that is **strictly increasing** up to a **single peak** element and then **strictly decreasing**.

## Examples

**Example 1:**
```
Input: nums = [1,3,2,1]
Output: 1

Explanation:
- Peak element is nums[1] = 3
- Ascending part = [1, 3], sum = 4
- Descending part = [3, 2, 1], sum = 6
- Descending sum is greater, return 1.
```

**Example 2:**
```
Input: nums = [2,4,5,2]
Output: 0

Explanation:
- Peak element is nums[2] = 5
- Ascending part = [2, 4, 5], sum = 11
- Descending part = [5, 2], sum = 7
- Ascending sum is greater, return 0.
```

**Example 3:**
```
Input: nums = [1,2,4,3]
Output: -1

Explanation:
- Peak element is nums[2] = 4
- Ascending part = [1, 2, 4], sum = 7
- Descending part = [4, 3], sum = 7
- Both equal, return -1.
```

## Constraints

- `3 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `nums` is a bitonic array.
