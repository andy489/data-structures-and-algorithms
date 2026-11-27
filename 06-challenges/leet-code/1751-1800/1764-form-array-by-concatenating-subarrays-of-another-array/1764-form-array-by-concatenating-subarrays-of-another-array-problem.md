# 1764. Form Array by Concatenating Subarrays of Another Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/

---

## Problem Statement

You are given a 2D integer array `groups` of length `n`. You are also given an integer array `nums`.

You are asked if you can choose `n` **disjoint** subarrays from the array `nums` such that the `i`th subarray is equal to `groups[i]` (**0-indexed**), and if `i > 0`, the `(i-1)`th subarray appears **before** the `i`th subarray in `nums` (i.e., the subarrays must be chosen in order from left to right).

Return `true` *if you can do this task, and* `false` *otherwise*.

Note that the subarrays are **disjoint** if and only if there is no index `k` such that `nums[k]` belongs to more than one subarray. A subarray is a contiguous sequence of elements within an array.

---

## Examples

**Example 1:**
```
Input: groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]
Output: true
Explanation: You can choose the 0th subarray as [1,-1,0,1,-1,-1,3,-2,0] and the 1st one as [1,-1,0,1,-1,-1,3,-2,0].
These subarrays are disjoint as the indices chosen are respectively [3,4,5] and [6,7,8].
```

**Example 2:**
```
Input: groups = [[10,-2],[1,2,3,4]], nums = [1,2,3,4,10,-2]
Output: false
Explanation: Note that choosing the subarrays [1,2,3,4,10,-2] and [1,2,3,4,10,-2] is incorrect because they are not in order (the first subarray must come before the second subarray).
```

**Example 3:**
```
Input: groups = [[1,2,3],[3,4]], nums = [7,7,1,2,3,4,7,7]
Output: false
Explanation: Note that choosing the subarrays [7,7,1,2,3,4,7,7] and [7,7,1,2,3,4,7,7] is incorrect because they are not disjoint (they share index 3).
```

---

## Constraints

- `groups.length == n`
- `1 <= n <= 10^3`
- `1 <= groups[i].length <= 10^3`
- `1 <= sum(groups[i].length) <= 10^3`
- `1 <= nums.length <= 10^3`
- `-10^7 <= groups[i][j], nums[k] <= 10^7`
