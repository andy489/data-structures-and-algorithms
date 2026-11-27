# 1046. Last Stone Weight

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/last-stone-weight/

---

## Problem Statement

You are given an array of integers `stones` where `stones[i]` is the weight of the `i`th stone.

We are playing a game with the stones. On each turn, we choose the two **heaviest** stones and smash them together. Suppose the heaviest two stones have weights `x` and `y` with `x <= y`. The result is:
- If `x == y`, both stones are destroyed.
- If `x != y`, the stone of weight `x` is destroyed, and the stone of weight `y` has new weight `y - x`.

Return the weight of the last remaining stone. If there are no stones left, return `0`.

---

## Examples

**Example 1:**
```
Input:  stones = [2,7,4,1,8,1]
Output: 1
```

**Example 2:**
```
Input:  stones = [1]
Output: 1
```

---

## Constraints

- `1 <= stones.length <= 30`
- `1 <= stones[i] <= 1000`
