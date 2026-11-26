# 810. Chalkboard XOR Game

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/chalkboard-xor-game/

---

## Problem Statement

You are given an array of integers `nums` representing the numbers written on a chalkboard. Alice and Bob take turns erasing any one number. The first player who erases a number that makes the XOR of all remaining numbers equal to 0 loses. Alice goes first.

Also if at any point all numbers are erased, the current player wins.

Return `true` if and only if Alice wins the game, assuming both players play optimally.

---

## Examples

**Example 1:**
```
Input:  nums = [1,1,2]
Output: false
```

**Example 2:**
```
Input:  nums = [0,3,2]
Output: true  (Alice removes 0, leaving [3,2] which XOR to 1 ≠ 0)
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 2^16`
