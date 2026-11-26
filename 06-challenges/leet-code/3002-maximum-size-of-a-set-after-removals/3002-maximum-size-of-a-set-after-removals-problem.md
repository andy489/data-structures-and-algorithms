# 3002. Maximum Size of a Set After Removals

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-size-of-a-set-after-removals/

---

## Problem Statement

You are given two 0-indexed integer arrays `nums1` and `nums2` of even length `n`.

You must remove `n / 2` elements from `nums1` and `n / 2` elements from `nums2`. After the removals, insert the remaining elements of `nums1` and `nums2` into a set `s`.

Return the maximum possible size of the set `s`.

---

## Examples

**Example 1:**
```
Input:  nums1 = [1,2,1,2], nums2 = [1,1,1,1]
Output: 2
```
Explanation: Remove 2 elements from each. Best we can do: keep {1,2} from nums1, keep {1} from nums2 → size 2.

**Example 2:**
```
Input:  nums1 = [1,2,3,4,5,6], nums2 = [2,3,2,3,2,3]
Output: 5
```

---

## Constraints

- `n == nums1.length == nums2.length`
- `1 <= n <= 2 * 10^4`
- `n` is even
- `1 <= nums1[i], nums2[i] <= 10^9`
