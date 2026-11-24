# 632. Smallest Range Covering Elements from K Lists

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

---

## Problem Statement

You have `k` lists of sorted integers in **non-decreasing order**. Find the **smallest range** `[a, b]` that includes at least one number from each of the `k` lists.

We define the range `[a, b]` as smaller than `[c, d]` if `b - a < d - c` or `a < c` when `b - a == d - c`.

---

## Examples

**Example 1:**
```
Input:  nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
```

**Example 2:**
```
Input:  nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]
```

---

## Constraints

- `nums.length == k`
- `1 <= k <= 3500`
- `1 <= nums[i].length <= 50`
- `-10^5 <= nums[i][j] <= 10^5`
- `nums[i]` is in non-decreasing order
