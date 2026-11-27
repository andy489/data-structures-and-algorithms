# 1818. Minimum Absolute Sum Difference

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-absolute-sum-difference/

---

## Problem Statement

You are given two positive integer arrays `nums1` and `nums2`, both of length `n`.

The **absolute sum difference** of arrays `nums1` and `nums2` is defined as the **sum** of `|nums1[i] - nums2[i]|` for each `0 <= i < n` (**0-indexed**).

You can replace **at most one** element of `nums1` with **any** other element in `nums1` to **minimize** the absolute sum difference.

Return the **minimum** absolute sum difference **after** replacing at most one element in the array `nums1`. Since the answer may be large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input: nums1 = [1,7,5], nums2 = [2,3,5]
Output: 3
Explanation: There are two possible optimal solutions:
- Replace the second element with the first: [1,1,5] => |1-2| + |1-3| + |5-5| = 1 + 2 + 0 = 3
- Replace the second element with the third: [1,5,5] => |1-2| + |5-3| + |5-5| = 1 + 2 + 0 = 3
```

**Example 2:**
```
Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
Output: 0
Explanation: nums1 is equal to nums2 so no replacement is needed. The absolute sum difference is 0.
```

**Example 3:**
```
Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
Output: 20
Explanation: Replace the first element with the second: [10,10,4,4,2,7] => |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 1 + 7 + 1 + 3 + 5 + 3 = 20
```

---

## Constraints

- `n == nums1.length`
- `n == nums2.length`
- `1 <= n <= 10^5`
- `1 <= nums1[i], nums2[i] <= 10^5`
