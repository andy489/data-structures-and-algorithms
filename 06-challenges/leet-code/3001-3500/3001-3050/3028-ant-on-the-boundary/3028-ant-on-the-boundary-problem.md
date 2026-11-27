# 3028. Ant On The Boundary

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/ant-on-the-boundary/

---

## Problem Statement

An ant is on a boundary. It sometimes goes left and sometimes right.

You are given an array of non-zero integers `nums`. The ant starts reading `nums` from the first element of it to its end. At each step, it moves according to the value of the current element:
- If `nums[i] < 0`, it moves left by `-nums[i]` units.
- If `nums[i] > 0`, it moves right by `nums[i]` units.

Return the number of times the ant returns to the boundary during its traversal of `nums`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,3,-5]
Output: 1
```
Explanation: After [2]: pos=2. After [3]: pos=5. After [-5]: pos=0 → returns to boundary. Count=1.

**Example 2:**
```
Input:  nums = [3,2,-3,-4]
Output: 0
```
Explanation: Positions: 3,5,2,-2. Never returns to 0.

---

## Constraints

- `1 <= nums.length <= 100`
- `-10 <= nums[i] <= 10`
- `nums[i] != 0`
