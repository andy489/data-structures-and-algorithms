# 1829. Maximum XOR for Each Query

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-xor-for-each-query/

---

## Problem Statement

You are given a **sorted** array `nums` of `n` non-negative integers and an integer `maximumBit`. You want to perform the following query `n` times:

1. Find a non-negative integer `k < 2^maximumBit` such that `nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k` is **maximized**. `k` is the answer to the `i`th query.
2. Remove the **last** element from the current array `nums`.

Return an array `answer`, where `answer[i]` is the answer to the `i`th query.

---

## Examples

**Example 1:**
```
Input: nums = [0,1,1,3], maximumBit = 2
Output: [0,3,2,3]
Explanation: The queries are answered as follows:
1st query: nums = [0,1,1,3], k = 0 since 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3.
2nd query: nums = [0,1,1], k = 3 since 0 XOR 1 XOR 1 XOR 3 = 3.
3rd query: nums = [0,1], k = 2 since 0 XOR 1 XOR 2 = 3.
4th query: nums = [0], k = 3 since 0 XOR 3 = 3.
```

**Example 2:**
```
Input: nums = [2,3,4,7], maximumBit = 3
Output: [5,2,6,5]
```

**Example 3:**
```
Input: nums = [0,1,2,2,5,7], maximumBit = 3
Output: [4,3,6,4,6,7]
```

---

## Constraints

- `nums.length == n`
- `1 <= n <= 10^5`
- `1 <= maximumBit <= 20`
- `0 <= nums[i] < 2^maximumBit`
- `nums` is sorted in **ascending** order.
