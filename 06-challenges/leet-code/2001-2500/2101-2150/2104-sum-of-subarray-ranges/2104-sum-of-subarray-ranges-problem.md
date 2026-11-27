# 2104. Sum of Subarray Ranges

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/sum-of-subarray-ranges/

---

## Problem Statement

You are given an integer array `nums`. The **range** of a subarray of `nums` is the difference between the largest and smallest element in the subarray.

Return the **sum of all subarray ranges** of `nums`.

A subarray is a contiguous non-empty sequence of elements within an array.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays and their ranges:
[1] → 0, [2] → 0, [3] → 0
[1,2] → 1, [2,3] → 1, [1,2,3] → 2
Sum = 0+0+0+1+1+2 = 4.
```

**Example 2:**
```
Input:  nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays and their ranges:
[1] → 0, [3] → 0, [3] → 0
[1,3] → 2, [3,3] → 0, [1,3,3] → 2
Sum = 0+0+0+2+0+2 = 4.
```

**Example 3:**
```
Input:  nums = [4,-2,-3,4,1]
Output: 59
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `-10^9 <= nums[i] <= 10^9`

**Follow-up:** Could you find a solution with O(n) time complexity?
