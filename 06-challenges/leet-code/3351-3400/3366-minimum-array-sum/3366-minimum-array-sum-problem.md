# 3366. Minimum Array Sum

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-array-sum/

---

## Problem Statement

You are given an integer array `nums` and three integers `k`, `op1`, and `op2`.

You can perform the following operations on `nums`:

- **Operation 1**: Choose an index `i` and divide `nums[i]` by 2, **rounding up** to the nearest whole number. You can perform this operation at most `op1` times, and not more than **once** per index.
- **Operation 2**: Choose an index `i` and subtract `k` from `nums[i]`, but only if `nums[i]` is greater than or equal to `k`. You can perform this operation at most `op2` times, and not more than **once** per index.

**Note:** Both operations can be applied to the same index, but at most once each.

Return the **minimum** possible **sum** of all elements in `nums` after performing any number of operations.

---

## Examples

**Example 1:**
```
Input:  nums = [2,8,3,19,3], k = 3, op1 = 1, op2 = 1
Output: 23
```
Apply Op2 to nums[1]=8 → 5; apply Op1 to nums[3]=19 → 10. Sum = 2+5+3+10+3 = 23.

**Example 2:**
```
Input:  nums = [2,4,3], k = 3, op1 = 2, op2 = 1
Output: 3
```
Apply Op1 to nums[0]=2 → 1, Op1 to nums[1]=4 → 2, Op2 to nums[2]=3 → 0. Sum = 1+2+0 = 3.

---

## Constraints

- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 10^5`
- `0 <= k <= 10^5`
- `0 <= op1, op2 <= nums.length`
