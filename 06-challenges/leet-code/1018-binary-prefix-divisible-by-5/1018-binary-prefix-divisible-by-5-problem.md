# 1018. Binary Prefix Divisible By 5

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-prefix-divisible-by-5/

---

## Problem Statement

You are given a binary array `nums` (0-indexed).

We define `x_i` as the number whose binary representation is the subarray `nums[0..i]` (from MSB to LSB).

For each `i`, return a boolean list where `answer[i]` is true if `x_i` is divisible by 5.

---

## Examples

**Example 1:**
```
Input:  nums = [0,1,1]
Output: [true,false,false]
```

**Example 2:**
```
Input:  nums = [1,1,1,0,1]
Output: [false,false,false,false,false]
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `nums[i]` is `0` or `1`.
