# 3069. Distribute Elements Into Two Arrays I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/distribute-elements-into-two-arrays-i/

---

## Problem Statement

You are given a 1-indexed integer array `nums` of length 3 where all values are distinct.

Return an array where the first element is appended to `arr1` and the second element is appended to `arr2`. From the third element onwards, if the last element of `arr1` is greater than the last element of `arr2`, append it to `arr1`; otherwise append to `arr2`.

Return the concatenation of `arr1` followed by `arr2`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,1,3]
Output: [2,1,3]
```
Explanation: arr1=[2], arr2=[1]. 3: last(arr1)=2 > last(arr2)=1 → arr1=[2,3]. Result=[2,3,1].

**Example 2:**
```
Input:  nums = [5,14,3,1,2]
Output: [5,3,1,2,14]
```
Explanation: arr1=[5], arr2=[14]. 3: 5<14 → arr2=[14,3]. 1: 5<3 → arr2=[14,3,1]. 2: 5<1 → arr2=[14,3,1,2]. Result=[5,14,3,1,2].

---

## Constraints

- `3 <= nums.length <= 50`
- `1 <= nums[i] <= 100`
- `All elements of nums are distinct.`
