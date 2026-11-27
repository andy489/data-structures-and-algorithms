# 740. Delete and Earn

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-and-earn/

---

## Problem Statement

You are given an integer array `nums`. You want to maximize the number of points you get by performing the following operation any number of times:

- Pick any `nums[i]` and delete it to earn `nums[i]` points. Afterwards, you must delete **every** element equal to `nums[i] - 1` and every element equal to `nums[i] + 1`.

Return the **maximum number of points** you can earn by applying the above operation some number of times.

---

## Examples

**Example 1:**
```
Input:  nums = [3,4,2]
Output: 6
Explanation: Delete 4 to earn 4 points. Delete 3, then delete 2 to earn 2 points. 6 total.
```

**Example 2:**
```
Input:  nums = [2,2,3,3,3,4]
Output: 9
Explanation: Delete 3 to earn 3 points, 3 times. Then 4 and 2 are deleted. 9 total.
```

---

## Constraints

- `1 <= nums.length <= 2 * 10^4`
- `1 <= nums[i] <= 10^4`
