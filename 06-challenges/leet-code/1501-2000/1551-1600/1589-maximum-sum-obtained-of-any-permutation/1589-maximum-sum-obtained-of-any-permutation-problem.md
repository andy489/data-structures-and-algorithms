# 1589. Maximum Sum Obtained of Any Permutation

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/

---

## Problem Statement

We have an array of integers `nums`, and an array of `requests` where `requests[i] = [starti, endi]`. The `i`th request asks for the sum of `nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]`. Both `starti` and `endi` are 0-indexed.

Return the maximum total sum of all requests **among all permutations** of `nums`.

Since the answer may be too large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
Output: 19
```

**Example 2:**
```
Input:  nums = [1,2,3,4,5,6], requests = [[0,1]]
Output: 11
```

**Example 3:**
```
Input:  nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
Output: 47
```

---

## Constraints

- `n == nums.length`
- `1 <= n <= 10^5`
- `0 <= nums[i] <= 10^5`
- `1 <= requests.length <= 10^5`
- `requests[i].length == 2`
- `0 <= starti <= endi < n`
