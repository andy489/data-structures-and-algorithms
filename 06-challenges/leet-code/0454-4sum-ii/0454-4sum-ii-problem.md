# 454. 4Sum II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/4sum-ii/

---

## Problem Statement

Given four integer arrays `nums1`, `nums2`, `nums3`, and `nums4` all of length `n`, return the number of tuples `(i, j, k, l)` such that:

- `0 <= i, j, k, l < n`
- `nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0`

---

## Examples

**Example 1:**
```
Input:  nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
```

**Example 2:**
```
Input:  nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1
```

---

## Constraints

- `n == nums1.length == nums2.length == nums3.length == nums4.length`
- `1 <= n <= 200`
- `-2^28 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2^28`
