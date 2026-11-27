# 3868. Minimum Cost to Equalize Arrays Using Swaps

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/

## Problem

You are given two integer arrays `nums1` and `nums2` of size `n`.

You can perform the following two operations any number of times:
- **Swap within the same array:** Choose two indices `i` and `j`. Swap either `nums1[i]` and `nums1[j]`, or `nums2[i]` and `nums2[j]`. This is **free**.
- **Swap between two arrays:** Choose an index `i`. Swap `nums1[i]` and `nums2[i]`. This costs **1**.

Return the minimum cost to make `nums1` and `nums2` identical. If this is not possible, return `-1`.

## Examples

**Example 1:**
```
Input: nums1 = [10,20], nums2 = [20,10]
Output: 0
Explanation: Swap nums2[0] and nums2[1] (free). Now both arrays are [10,20].
```

**Example 2:**
```
Input: nums1 = [10,10], nums2 = [20,20]
Output: 1
Explanation: Swap nums1[0] and nums2[0] (cost 1) -> nums1=[20,10], nums2=[10,20]. Then swap nums2[0] and nums2[1] (free) -> nums2=[20,10]. Both are identical [20,10].
Wait — actually nums1=[20,10] and nums2=[20,10] after this. Cost = 1.
```

**Example 3:**
```
Input: nums1 = [10,20], nums2 = [30,40]
Output: -1
Explanation: Impossible to make arrays identical.
```

## Constraints

- `2 <= n == nums1.length == nums2.length <= 8 * 10^4`
- `1 <= nums1[i], nums2[i] <= 8 * 10^4`
