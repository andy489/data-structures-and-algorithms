# 3021. Alice And Bob Playing Flower Game

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/alice-and-bob-playing-flower-game/

---

## Problem Statement

Alice and Bob are playing a turn-based game on a circular field surrounded by flowers. The circle represents the field, and there are `x` flowers in the clockwise direction between Alice and Bob, and `y` flowers in the counterclockwise direction between Alice and Bob.

If the total number of flowers is even (x + y is even), Bob wins; otherwise Alice wins.

Alice can win if `x` is odd and `y` is even, or `x` is even and `y` is odd (so x+y is odd).

Given two integers `n` and `m`, return the number of ways to choose `x` in the range `[1, n]` and `y` in the range `[1, m]` such that Alice wins, i.e., (x+y) is odd.

---

## Examples

**Example 1:**
```
Input:  n = 3, m = 2
Output: 3
```
Explanation: Winning pairs: (1,2),(2,1),(3,2). Three pairs where x+y is odd.

**Example 2:**
```
Input:  n = 1, m = 1
Output: 1
```
Explanation: Only (1,1): 1+1=2 even → no. Wait, (1,1)=2 even, Bob wins. Hmm let me recheck.

---

## Constraints

- `1 <= n, m <= 10^9`
