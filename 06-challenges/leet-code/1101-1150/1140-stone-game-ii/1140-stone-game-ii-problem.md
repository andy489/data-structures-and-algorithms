# 1140. Stone Game II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/stone-game-ii/

---

## Problem Statement

Alice and Bob continue their games with piles of stones. There are a number of piles arranged in a row, and each pile has a positive integer number of stones `piles[i]`. The objective of the game is to end with the most stones.

Alice and Bob take turns, with Alice starting first. On each player's turn, that player can take all the stones in the first `X` remaining piles, where `1 <= X <= 2M`. Then, we set `M = max(M, X)`. Initially, `M = 1`.

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

---

## Examples

**Example 1:**
```
Input:  piles = [2,7,9,4,4]
Output: 10
Explanation: Alice takes 1 pile (2), Bob takes 2 piles (7,9), Alice takes 2 piles (4,4). Alice gets 2+4+4=10.
```

**Example 2:**
```
Input:  piles = [1,2,3,4,5,100]
Output: 104
```

---

## Constraints

- `1 <= piles.length <= 100`
- `1 <= piles[i] <= 10^4`
