# 81. Search in Rotated Sorted Array II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

---

## Problem Statement

There is an integer array `nums` sorted in non-decreasing order (not necessarily with **distinct** values). Before being passed to your function, `nums` is **possibly rotated** at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]`.

Given the array `nums` after the possible rotation and an integer `target`, return `true` if `target` is in `nums`, or `false` if it is not.

You must decrease the overall operation steps as much as possible.

---

## Examples

**Example 1:**
```
Input:  nums = [2,5,6,0,0,1,2], target = 0
Output: true
```

**Example 2:**
```
Input:  nums = [2,5,6,0,0,1,2], target = 3
Output: false
```

---

## Constraints

- `1 <= nums.length <= 5000`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is an integer array sorted in non-decreasing order (with possible duplicates).
- `-10^4 <= target <= 10^4`

**Follow up:** This problem is similar to [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/), but `nums` may contain **duplicates**. Would this affect the runtime complexity? How and why?
