# 3375. Minimum Operations to Make Array Values Equal to K

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/

---

## Problem Statement

You are given an integer array `nums` and an integer `k`.

An integer `h` is called **valid** if all values in the array that are **strictly greater** than `h` are *identical*.

You are allowed to perform the following operation on `nums`:

- Select an integer `h` that is *valid* for the **current** values in `nums`.
- For each index `i` where `nums[i] > h`, set `nums[i]` to `h`.

Return the **minimum** number of operations required to make every element in `nums` **equal** to `k`. If it is impossible to make all elements equal to `k`, return -1.

---

## Examples

**Example 1:**
```
Input:  nums = [5,2,5,4,5], k = 2
Output: 2
```
Operations using valid integers 4 and then 2.

**Example 2:**
```
Input:  nums = [2,1,2], k = 2
Output: -1
```
Impossible — 1 < k=2 and cannot be increased.

**Example 3:**
```
Input:  nums = [9,7,5,3], k = 1
Output: 4
```
Operations using 7, 5, 3, and 1 in order.

---

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
- `1 <= k <= 100`
