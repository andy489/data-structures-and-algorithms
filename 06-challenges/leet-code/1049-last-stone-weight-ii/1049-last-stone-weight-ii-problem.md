# 1049. Last Stone Weight II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/last-stone-weight-ii/

---

## Problem Statement

You are given an array of integers `stones` where `stones[i]` is the weight of the `i`th stone.

We are playing a game with the stones. On each turn, we choose **any two stones** and smash them together. The result is the same as before: stones of equal weight both destroyed, unequal weights: the lighter one destroyed, heavier gets new weight = difference.

Return the **smallest possible** weight of the left over stone. (If there are no stones left, return 0.)

---

## Examples

**Example 1:**
```
Input:  stones = [2,7,4,1,8,1]
Output: 1
```

**Example 2:**
```
Input:  stones = [31,26,33,21,40]
Output: 5
```

---

## Constraints

- `1 <= stones.length <= 30`
- `1 <= stones[i] <= 100`
