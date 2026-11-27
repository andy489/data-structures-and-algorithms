# 1509. Minimum Difference Between Largest and Smallest Value in Three Moves

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

---

## Problem Statement

You are given an integer array `nums`.

In one move, you can choose one element of `nums` and change it to any value.

Return the minimum difference between the largest and smallest value of `nums` after performing **at most three moves**.

---

## Examples

**Example 1:**
```
Input:  nums = [5,3,2,4]
Output: 0
Explanation: We can make at most 3 moves.
In the first move, change 2 to 3. nums becomes [5,3,3,4].
In the second move, change 4 to 3. nums becomes [5,3,3,3].
In the third move, change 5 to 3. nums becomes [3,3,3,3].
After performing 3 moves, the minimum difference between the maximum and minimum is 0.
```

**Example 2:**
```
Input:  nums = [1,5,0,10,14]
Output: 1
Explanation: We can make at most 3 moves.
In the first move, change 5 to 0. nums becomes [1,0,0,10,14].
In the second move, change 10 to 0. nums becomes [1,0,0,0,14].
In the third move, change 14 to 1. nums becomes [1,0,0,0,1].
After performing 3 moves, the minimum difference between the maximum and minimum is 1.
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
