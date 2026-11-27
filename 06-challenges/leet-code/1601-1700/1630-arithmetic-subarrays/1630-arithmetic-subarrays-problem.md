# 1630. Arithmetic Subarrays

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/arithmetic-subarrays/

---

## Problem Statement

A sequence of numbers is called **arithmetic** if it consists of at least two elements, and the difference between every two consecutive elements is the same. More formally, a sequence `s` is arithmetic if and only if `s[1] - s[0] == s[2] - s[1] == ... == s[s.length - 1] - s[s.length - 2]`.

For example, these are **arithmetic** sequences: `1, 3, 5, 7, 9`, `7, 7, 7, 7`, `3, -1, -5, -9`.

For the following examples, these are **not arithmetic** sequences: `1, 1, 2, 5, 7`.

You are given an array of `n` integers, `nums`, and two arrays of `m` integers each, `l` and `r`, representing the `m` range queries, where the `i`th query asks if the subarray `nums[l[i]], nums[l[i]+1], ... , nums[r[i]]` can be rearranged to form an **arithmetic** sequence.

Return a list of boolean values `answer`, where `answer[i]` is `true` if the subarray can be rearranged to form an arithmetic sequence, and `false` otherwise.

---

## Examples

**Example 1:**
```
Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
Output: [true,false,true]
```

**Example 2:**
```
Input: nums = [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10], l = [0,1,6,4,8,7], r = [4,4,9,7,9,10]
Output: [false,true,false,false,true,true]
```

---

## Constraints
- `n == nums.length`
- `m == l.length`
- `m == r.length`
- `2 <= n <= 500`
- `1 <= m <= 500`
- `0 <= l[i] < r[i] < n`
- `-10^5 <= nums[i] <= 10^5`
