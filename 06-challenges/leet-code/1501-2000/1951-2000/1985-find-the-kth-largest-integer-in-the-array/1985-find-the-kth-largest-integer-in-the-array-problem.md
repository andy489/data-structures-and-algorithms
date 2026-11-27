# 1985. Find the Kth Largest Integer in the Array

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/

## Problem

You are given an array of strings `nums` and an integer `k`. Each string in `nums` represents an integer without leading zeros.

Return the string that represents the `k`th largest integer in `nums`.

**Note:** Duplicate numbers should be counted distinctly. For example, if `nums` is `["1","2","2"]`, `"2"` is the first largest integer, `"2"` is the second-largest integer, and `"1"` is the third-largest integer.

## Examples

**Example 1:**
```
Input: nums = ["3","6","7","10"], k = 4
Output: "3"
```

**Example 2:**
```
Input: nums = ["2","21","12","1"], k = 3
Output: "2"
```

**Example 3:**
```
Input: nums = ["0","0"], k = 2
Output: "0"
```

## Constraints

- `1 <= k <= nums.length <= 10^4`
- `1 <= nums[i].length <= 100`
- `nums[i]` consists of only digits.
- `nums[i]` will not have any leading zeros.
