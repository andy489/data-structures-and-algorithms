# 1025. Divisor Game

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/divisor-game/

---

## Problem Statement

Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number `n` on the chalkboard. On each player's turn, that player makes a move consisting of:

- Choosing any `x` with `0 < x < n` and `n % x == 0`.
- Replacing the number `n` on the chalkboard with `n - x`.

If a player cannot make a move, they lose the game.

Return `true` if and only if Alice wins the game, assuming both players play optimally.

---

## Examples

**Example 1:**
```
Input:  n = 2
Output: true
```

**Example 2:**
```
Input:  n = 3
Output: false
```

---

## Constraints

- `1 <= n <= 1000`
