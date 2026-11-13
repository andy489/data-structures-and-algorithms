# 45. Jump Game II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/jump-game-ii/

---

## Problem Statement

You are given a 0-indexed array of integers `nums` of length `n`. You are initially positioned at `nums[0]`.

Each element `nums[i]` represents the maximum length of a forward jump from index `i`. In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:

- `0 <= j <= nums[i]` and
- `i + j < n`

Return the minimum number of jumps to reach `nums[n - 1]`. The test cases are generated such that you can always reach `nums[n - 1]`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,3,1,1,4]
Output: 2
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**
```
Input:  nums = [2,3,0,1,4]
Output: 2
```

---

## Constraints

- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 1000`
- The generated tests are such that you can always reach `nums[n - 1]`.
