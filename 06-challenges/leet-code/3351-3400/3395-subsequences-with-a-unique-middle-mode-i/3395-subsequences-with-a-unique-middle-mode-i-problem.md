# 3395. Subsequences With a Unique Middle Mode I

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/subsequences-with-a-unique-middle-mode-i/

---

## Problem Statement

Given an integer array `nums`, return the number of subsequences of size 5 where the middle element (at index 2 of the subsequence) is a **unique mode** — it appears strictly more times than any other element in that subsequence.

Since the answer can be very large, return it modulo `10^9 + 7`.

A **mode** of a sequence is the element that appears most frequently. It is **unique** if no other element appears as frequently.

---

## Examples

**Example 1:**
```
Input:  nums = [1,1,1,1,1,1]
Output: 6
```

**Example 2:**
```
Input:  nums = [1,2,2,3,3,4]
Output: 4
```

**Example 3:**
```
Input:  nums = [0,1,2,3,4,5,6,7,8]
Output: 0
```

---

## Constraints

- `5 <= nums.length <= 1000`
- `-10^9 <= nums[i] <= 10^9`
