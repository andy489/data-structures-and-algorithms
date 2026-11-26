# 891. Sum of Subsequence Widths

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sum-of-subsequence-widths/

---

## Problem Statement

The width of a sequence is the difference between the maximum and minimum elements in the sequence.

Given an array of integers `nums`, return the sum of the widths of all the non-empty subsequences of `nums`. Since the answer may be very large, return it modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,1,3]
Output: 6
Explanation: Subsequences: [1]=0, [2]=0, [3]=0, [1,2]=1, [1,3]=2, [2,3]=1, [1,2,3]=2. Sum=6.
```

**Example 2:**
```
Input:  nums = [2]
Output: 0
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`
