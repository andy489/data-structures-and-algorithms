# 2106. Maximum Fruits Harvested After at Most K Steps

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/

---

## Problem Statement

Fruits are available at some positions on an infinite x-axis. You are given a 2D integer array `fruits` where `fruits[i] = [positioni, amounti]` depicts `amounti` fruits at the position `positioni`. `fruits` is already sorted by `positioni` in ascending order, and each `positioni` is unique.

You are also given an integer `startPos` and an integer `k`. Initially, you are at the position `startPos`. From any position, you can either walk to the left or right. It takes one step to move one unit on the x-axis, and you can walk at most `k` steps in total. For every position you reach, you harvest all the fruits at that position, and the fruits will disappear from that position.

Return the **maximum total number of fruits** you can harvest.

---

## Examples

**Example 1:**
```
Input:  fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
Output: 9
Explanation:
Move right to position 6 (harvest 3), then right to 8 (harvest 6). 3 steps total.
```

**Example 2:**
```
Input:  fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
Output: 14
Explanation:
Harvest 7 at start (pos 5), left to 4 (harvest 1), right to 6 (harvest 2), right to 7 (harvest 4). 4 steps.
```

**Example 3:**
```
Input:  fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
Output: 0
Explanation: Cannot reach any position with fruits.
```

---

## Constraints

- `1 <= fruits.length <= 10^5`
- `fruits[i].length == 2`
- `0 <= startPos, positioni <= 2 * 10^5`
- `positioni-1 < positioni` for any `i > 0` (0-indexed)
- `1 <= amounti <= 10^4`
- `0 <= k <= 2 * 10^5`
