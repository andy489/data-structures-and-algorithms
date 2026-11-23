# 493. Reverse Pairs

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reverse-pairs/

---

## Problem Statement

Given an integer array `nums`, return *the number of **reverse pairs** in the array*.

A reverse pair is a pair `(i, j)` where:

- `0 <= i < j < nums.length` and
- `nums[i] > 2 * nums[j]`

---

## Examples

**Example 1:**
```
Input:  nums = [1, 3, 2, 3, 1]
Output: 2
Explanation: The reverse pairs are: (1, 4) → 3 > 2*1, (3, 4) → 3 > 2*1
```

**Example 2:**
```
Input:  nums = [2, 4, 3, 5, 1]
Output: 3
Explanation: The reverse pairs are: (1,4), (2,4), (3,4)
```

---

## Constraints

- `1 <= nums.length <= 5 * 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`
