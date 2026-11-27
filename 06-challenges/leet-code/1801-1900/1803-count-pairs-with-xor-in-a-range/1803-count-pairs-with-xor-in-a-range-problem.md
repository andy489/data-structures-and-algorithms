# 1803. Count Pairs With XOR in a Range

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-pairs-with-xor-in-a-range/

---

## Problem Statement

Given a (0-indexed) integer array `nums` and two integers `low` and `high`, return the number of **nice pairs**.

A **nice pair** is a pair `(i, j)` where `0 <= i < j < nums.length` and `low <= (nums[i] XOR nums[j]) <= high`.

---

## Examples

**Example 1:**
```
Input: nums = [1,4,2,7], low = 2, high = 6
Output: 6
Explanation: All nice pairs (i, j) are:
- (0, 1): 1 XOR 4 = 5
- (0, 2): 1 XOR 2 = 3
- (0, 3): 1 XOR 7 = 6
- (1, 2): 4 XOR 2 = 6
- (1, 3): 4 XOR 7 = 3
- (2, 3): 2 XOR 7 = 5
```

**Example 2:**
```
Input: nums = [9,8,4,2,1], low = 5, high = 14
Output: 8
```

---

## Constraints

- `1 <= nums.length <= 2 * 10^4`
- `1 <= nums[i] <= 2 * 10^4`
- `0 <= low <= high <= 2 * 10^4`
