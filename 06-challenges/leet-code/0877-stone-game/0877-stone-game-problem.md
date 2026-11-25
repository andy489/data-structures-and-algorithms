# 877. Stone Game

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/stone-game/

---

## Problem Statement

Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones `piles[i]`.

The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.

Alice and Bob take turns, with Alice going first. Each turn, a player takes the entire pile of stones from either the beginning or the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alice and Bob play optimally, return `true` if Alice wins the game, or `false` if Bob wins.

---

## Examples

**Example 1:**
```
Input:  piles = [5,3,4,5]
Output: true
```

---

## Constraints

- `2 <= piles.length <= 500`
- `piles.length` is even.
- `1 <= piles[i] <= 500`
- `sum(piles[i])` is odd.
