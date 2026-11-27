# 1537. Get the Maximum Score

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/get-the-maximum-score/

---

## Problem Statement

You are given two sorted arrays of distinct integers `nums1` and `nums2`.

A valid path is defined as follows:
- Choose array `nums1` or `nums2` to traverse (from index-0).
- Traverse the current array from left to right.
- If you are reading any value that is present in `nums1` and `nums2` you are allowed to change your path to the other array. (Only one repeated value is counted once)

Score is defined as the sum of unique values in a valid path.

Return the maximum score you can obtain of all possible valid paths. Since the answer may be too large, return it modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input: nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]
Output: 30
Explanation: Valid paths: [2,4,5,8,10], [2,4,5,8,9], [2,4,6,8,10], [2,4,6,8,9], [4,5,8,10], [4,5,8,9], [4,6,8,10], [4,6,8,9]
Maximum is: 4 + 6 + 8 + 10 = 30 (or 2 + 4 + 6 + 8 + 10 = 30 as well).
```

**Example 2:**
```
Input: nums1 = [1,3,5,7,9], nums2 = [3,5,100]
Output: 109
```

---

## Constraints
- `1 <= nums1.length, nums2.length <= 10^5`
- `1 <= nums1[i], nums2[i] <= 10^7`
- `nums1` and `nums2` are strictly increasing.
