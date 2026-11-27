# 1674. Minimum Moves to Make Array Complementary

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-moves-to-make-array-complementary/

---

## Problem Statement

You are given an integer array `nums` of **even** length `n` and an integer `limit`. In one move, you can replace any integer from `nums` with another integer between `1` and `limit`, inclusive.

The array `nums` is **complementary** if for all indices `i` (**0-indexed**), `nums[i] + nums[n - 1 - i]` equals the same number. For example, the array `[1,2,3,4]` is complementary because for all indices `i`, `nums[i] + nums[n - 1 - i] = 5`.

Return the **minimum** number of moves required to make `nums` **complementary**.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,4,3], limit = 4
Output: 1
Explanation: In 1 move, you can change nums[1] to 3: [1,3,4,3] -> each pair sums to 4. 
```

**Example 2:**
```
Input: nums = [1,2,2,1], limit = 2
Output: 2
Explanation: In 2 moves, you can change nums[0] to 2 and nums[3] to 2: [2,2,2,2] -> each pair sums to 4.
```

**Example 3:**
```
Input: nums = [1,2,1,2], limit = 2
Output: 0
```

---

## Constraints

- `n == nums.length`
- `2 <= n <= 10^5`
- `1 <= nums[i] <= limit <= 10^5`
- `n` is even.
