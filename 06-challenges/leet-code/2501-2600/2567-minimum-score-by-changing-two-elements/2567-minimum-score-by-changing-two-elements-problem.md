# 2567. Minimum Score by Changing Two Elements

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-score-by-changing-two-elements/

---

## Problem Statement

You are given a **0-indexed** integer array `nums`.

- The **low score** of `nums` is the minimum value of `|nums[i] - nums[j]|` over all `0 <= i < j <= nums.length - 1`.
- The **high score** of `nums` is the maximum value of `|nums[i] - nums[j]|` over all `0 <= i < j <= nums.length - 1`.
- The **score** of `nums` is the sum of the high and low scores.

To minimize the score, we can change the value of **at most two** elements of `nums`.

Return the **minimum** possible score after changing the value of **at most two** elements of `nums`.

Note that the absolute value of `x` is defined as follows:
- `x` if `x >= 0`
- `-x` if `x < 0`

---

## Examples

**Example 1:**
```
Input:  nums = [1,4,7,8,5]
Output: 3
```
*Explanation:* Change `nums[0] = 1` to `6` and `nums[1] = 4` to `6`. Now `nums = [6,6,7,8,5]`. The low score is `|6 - 6| = 0` and the high score is `|8 - 5| = 3`. Score = 0 + 3 = 3.

**Example 2:**
```
Input:  nums = [1,4,3]
Output: 0
```
*Explanation:* Change `nums[1] = 4` and `nums[2] = 3` to `1`. Now `nums = [1,1,1]`. Both scores are 0.

---

## Constraints

- `3 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
