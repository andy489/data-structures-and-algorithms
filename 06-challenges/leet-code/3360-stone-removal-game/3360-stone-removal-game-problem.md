# 3360. Stone Removal Game

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/stone-removal-game/

---

## Problem Statement

Alice and Bob are playing a turn-based game. Alice goes first. On each turn, a player removes stones from a pile:

- Alice removes exactly **10** stones on her first turn.
- Each subsequent turn, the current player must remove exactly **1 fewer** stone than the opponent removed on their previous turn.

A player who cannot perform their required removal **loses**.

Given the number of stones `n`, return `true` if Alice wins, `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  n = 12
Output: true
```
Explanation: Alice removes 10 stones (2 remain). Bob must remove 9 but only 2 remain — Bob loses.

**Example 2:**
```
Input:  n = 1
Output: false
```
Explanation: Alice must remove 10 stones but only 1 is available — Alice loses immediately.

---

## Constraints

- `1 <= n <= 50`
