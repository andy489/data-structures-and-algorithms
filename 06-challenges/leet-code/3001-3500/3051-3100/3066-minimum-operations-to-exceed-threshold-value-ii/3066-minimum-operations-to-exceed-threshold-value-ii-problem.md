# 3066. Minimum Operations To Exceed Threshold Value Ii

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

---

## Problem Statement

You are given a 0-indexed integer array `nums` and an integer `k`.

In one operation, you must:
- Take the two smallest elements `x` and `y` from `nums`, then remove them.
- Add `min(x, y) * 2 + max(x, y)` back to `nums`.

Return the minimum number of operations required so that all elements of `nums` are greater than or equal to `k`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,11,10,1,3], k = 10
Output: 2
```
Explanation: Op1: take 1,2 → 1*2+2=4. nums=[4,11,10,3]. Op2: take 3,4 → 3*2+4=10. nums=[10,11,10]. All>=10.

**Example 2:**
```
Input:  nums = [1,1,2,4,9], k = 20
Output: 4
```
Explanation: Need 4 operations.

---

## Constraints

- `2 <= nums.length <= 2 * 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= k <= 10^9`
