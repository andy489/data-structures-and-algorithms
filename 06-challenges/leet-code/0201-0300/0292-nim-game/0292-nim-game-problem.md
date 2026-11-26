# 292. Nim Game

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/nim-game/

---

## Problem Statement

You are playing the following Nim Game with your friend:

- Initially, there is a heap of stones on the table.
- You and your friend will alternate taking turns, and **you go first**.
- On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
- The one who removes the last stone is the winner.

Given `n`, the number of stones in the heap, return `true` if you can win the game assuming both you and your friend play optimally, otherwise return `false`.

---

## Examples

**Example 1:**
```
Input:  n = 4
Output: false
Explanation: No matter what you do, you will never win. If you remove 1 stone, your opponent removes 3. If you remove 2, your opponent removes 2. If you remove 3, your opponent removes 1.
```

**Example 2:**
```
Input:  n = 1
Output: true
```

**Example 3:**
```
Input:  n = 2
Output: true
```

---

## Constraints

- `1 <= n <= 2^31 - 1`
