# 1743. Restore the Array from Adjacent Pairs

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

---

## Problem Statement

There is an integer array `nums` that consists of `n` unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in `nums`.

You are given a 2D integer array `adjacentPairs` of size `n - 1` where each `adjacentPairs[i] = [ui, vi]` indicates that the elements `ui` and `vi` are adjacent in `nums`.

It is guaranteed that every adjacent pair of elements `nums[i]` and `nums[i+1]` will exist in `adjacentPairs`, either as `[nums[i], nums[i+1]]` or `[nums[i+1], nums[i]]`. The pairs can appear in any order.

Return the original array `nums`. If there are multiple solutions, return any of them.

---

## Examples

**Example 1:**
```
Input: adjacentPairs = [[2,1],[3,4],[3,2]]
Output: [1,2,3,4]
Explanation: This array has all its adjacent pairs in adjacentPairs.
```

**Example 2:**
```
Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
Output: [-2,4,1,-3]
Explanation: There might be multiple solutions. [-3,1,4,-2] is also correct.
```

**Example 3:**
```
Input: adjacentPairs = [[100000,-100000]]
Output: [100000,-100000]
```

---

## Constraints

- `nums.length == n`
- `adjacentPairs.length == n - 1`
- `adjacentPairs[i].length == 2`
- `2 <= n <= 10^5`
- `-10^5 <= nums[i], adjacentPairs[i][0], adjacentPairs[i][1] <= 10^5`
- There exists some `nums` that has `adjacentPairs` as its adjacent pairs.
