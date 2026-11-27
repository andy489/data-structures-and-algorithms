# 3074. Apple Redistribution Into Boxes

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/apple-redistribution-into-boxes/

---

## Problem Statement

You are given an array `apple` of size `n` and an array `capacity` of size `m`.

There are `n` packs of apples and `m` boxes. The ith pack contains `apple[i]` apples. The ith box has a capacity of `capacity[i]`.

Return the minimum number of boxes you need to select to redistribute these `n` packs of apples into boxes.

---

## Examples

**Example 1:**
```
Input:  apple = [1,3,2], capacity = [4,3,1,5,2]
Output: 2
```
Explanation: Total = 6. Use box of cap 5 and box of cap 4 → 9 >= 6. 2 boxes.

**Example 2:**
```
Input:  apple = [5,5,5], capacity = [2,4,2,7]
Output: 4
```
Explanation: Total = 15. Need all 4 boxes: 2+4+2+7=15.

---

## Constraints

- `1 <= n == apple.length <= 50`
- `1 <= m == capacity.length <= 50`
- `1 <= apple[i] <= 10^3`
- `1 <= capacity[i] <= 50`
