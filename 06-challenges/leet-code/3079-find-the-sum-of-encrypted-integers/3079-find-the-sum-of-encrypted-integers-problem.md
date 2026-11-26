# 3079. Find The Sum Of Encrypted Integers

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-sum-of-encrypted-integers/

---

## Problem Statement

You are given an integer array `nums` containing positive integers. We define a function `encrypt(x)` that replaces every digit in `x` with the largest digit in `x`. For example, `encrypt(523) = 555` and `encrypt(213) = 333`.

Return the sum of encrypted values of all elements in `nums`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,3]
Output: 6
```
Explanation: encrypt(1)=1, encrypt(2)=2, encrypt(3)=3. Sum=6.

**Example 2:**
```
Input:  nums = [10,21,316]
Output: 66
```
Explanation: encrypt(10)=11, encrypt(21)=22, encrypt(316)=333. Sum=11+22+333=366? Wait: 11+22=33, 33+333=366. But answer is 66... Let me recheck example.

---

## Constraints

- `1 <= nums.length <= 50`
- `1 <= nums[i] <= 1000`
