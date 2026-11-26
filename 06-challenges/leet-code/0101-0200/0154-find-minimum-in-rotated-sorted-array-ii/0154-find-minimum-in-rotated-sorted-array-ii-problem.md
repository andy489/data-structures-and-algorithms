# 154. Find Minimum in Rotated Sorted Array II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

---

## Problem Statement

Suppose an array of length `n` sorted in ascending order is **rotated** between `1` and `n` times. Given the sorted rotated array `nums` that **may contain duplicates**, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.

---

## Examples

**Example 1:**
```
Input:  nums = [1,3,5]
Output: 1
```

**Example 2:**
```
Input:  nums = [2,2,2,0,1]
Output: 0
```

---

## Constraints

- `n == nums.length`
- `1 <= n <= 5000`
- `-5000 <= nums[i] <= 5000`
- `nums` is sorted and rotated between `1` and `n` times.

**Follow up:** This problem is similar to [153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/), but `nums` may contain **duplicates**. Would this affect the runtime complexity? How and why?
