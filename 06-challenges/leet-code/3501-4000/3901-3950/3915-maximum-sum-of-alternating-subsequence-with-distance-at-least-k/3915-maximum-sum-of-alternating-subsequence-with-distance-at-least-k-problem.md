# 3915. Maximum Sum of Alternating Subsequence With Distance at Least K

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/maximum-sum-of-alternating-subsequence-with-distance-at-least-k/

## Problem

You are given an integer array `nums` of length `n` and an integer `k`.

Pick a **subsequence** with indices `0 <= i_1 < i_2 < ... < i_m < n` such that:
- For every `1 <= t < m`, `i_{t+1} - i_t >= k`.
- The selected values form a **strictly alternating** sequence. In other words, either:
  - `nums[i_1] < nums[i_2] > nums[i_3] < ...`, or
  - `nums[i_1] > nums[i_2] < nums[i_3] > ...`

A subsequence of length 1 is also considered **strictly alternating**. The score of a valid subsequence is the **sum** of its selected values.

Return an integer denoting the **maximum** possible **score** of a valid subsequence.

## Examples

**Example 1:**
```
Input: nums = [5,4,2], k = 2
Output: 7

Explanation: Indices [0,2] -> values [5,2]. Distance 2-0=2>=k. 5>2 (alternating). Score = 7.
```

**Example 2:**
```
Input: nums = [3,5,4,2,4], k = 1
Output: 14

Explanation: Indices [0,1,3,4] -> values [3,5,2,4]. 3<5>2<4. Score = 14.
```

**Example 3:**
```
Input: nums = [5], k = 1
Output: 5
```

## Constraints

- `1 <= n == nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`
- `1 <= k <= n`
