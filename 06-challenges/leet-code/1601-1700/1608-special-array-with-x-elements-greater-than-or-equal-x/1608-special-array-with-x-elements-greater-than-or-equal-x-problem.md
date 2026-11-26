# 1608. Special Array With X Elements Greater Than or Equal X

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

---

## Problem Statement

You are given an array `nums` of non-negative integers. `nums` is considered **special** if there exists a number `x` such that there are **exactly** `x` numbers in `nums` that are **greater than or equal to** `x`.

Note that `x` **does not** have to be an element in `nums`.

Return `x` if the array is special, otherwise return `-1`. It can be proven that if `nums` is special, the value for `x` is **unique**.

---

## Examples

**Example 1:**
```
Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are >= 2.
```

**Example 2:**
```
Input: nums = [0,0]
Output: -1
Explanation: No x satisfies the condition.
```

**Example 3:**
```
Input: nums = [0,4,3,0,4]
Output: 3
Explanation: There are 3 values (4, 3, 4) that are >= 3.
```

---

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 1000`
