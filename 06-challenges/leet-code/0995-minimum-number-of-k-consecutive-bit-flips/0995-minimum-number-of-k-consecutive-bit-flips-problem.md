# 995. Minimum Number of K Consecutive Bit Flips

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/

---

## Problem Statement

You are given a binary array `nums` and an integer `k`.

A k-bit flip is choosing a subarray of length `k` from `nums` and simultaneously changing every `0` in the subarray to `1`, and every `1` in the subarray to `0`.

Return the minimum number of k-bit flips required so that there is no `0` in the array. If it is not possible, return `-1`.

---

## Examples

**Example 1:**
```
Input:  nums = [0,1,0], k = 1
Output: 2
```

**Example 2:**
```
Input:  nums = [1,1,0], k = 2
Output: -1
```

**Example 3:**
```
Input:  nums = [0,0,0,1,0,1,1,0], k = 3
Output: 3
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= k <= nums.length`
- `nums[i]` is either `0` or `1`.
