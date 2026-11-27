# 2202. Maximize the Topmost Element After K Moves

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves/

## Problem

You are given a 0-indexed integer array nums representing the contents of a pile, where nums[0] is the topmost element of the pile.

In one move, you can perform either of the following:
- If the pile is not empty, remove the topmost element of the pile.
- If there are one or more removed elements, add any one of them back onto the pile. This element becomes the new topmost element.

You are also given an integer k, which denotes the total number of moves to be made.

Return the maximum value of the topmost element of the pile possible after exactly k moves. In case it is not possible to obtain a non-empty pile after k moves, return -1.

## Examples

**Example 1:**
```
Input: nums = [5,2,2,4,0,6], k = 4
Output: 5
```

**Example 2:**
```
Input: nums = [2], k = 1
Output: -1
```

## Constraints

- 1 <= nums.length <= 10⁵
- 0 <= nums[i], k <= 10⁹
