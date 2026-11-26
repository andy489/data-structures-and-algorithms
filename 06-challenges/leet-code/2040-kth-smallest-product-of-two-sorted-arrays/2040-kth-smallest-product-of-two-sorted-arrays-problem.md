# 2040. Kth Smallest Product of Two Sorted Arrays

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/

---

## Problem Statement

Given two sorted 0-indexed arrays `nums1` and `nums2` and an integer `k`, return the `k`-th (1-indexed) smallest product of `nums1[i] * nums2[j]`.

---

## Examples

**Example 1:**
```
Input:  nums1 = [2,5], nums2 = [3,4], k = 2
Output: 8
```
Explanation: Products: [6,8,15,20]. 2nd smallest = 8.

**Example 2:**
```
Input:  nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
Output: 0
```

**Example 3:**
```
Input:  nums1 = [-2,-1,0,1,2], nums2 = [-3,-1,2,4,5], k = 3
Output: -6
```

---

## Constraints

- `1 <= nums1.length, nums2.length <= 5 * 10^4`
- `-10^5 <= nums1[i], nums2[j] <= 10^5`
- `1 <= k <= nums1.length * nums2.length`
