# 679. 24 Game

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/24-game/

---

## Problem Statement

You are given an integer array `cards` of length `4`. You have four cards, each containing a number in the range `[1, 9]`. You should use the following rules to reach a target value of `24`:

- Use all 4 numbers, each exactly once.
- Use basic arithmetic operators: `+`, `-`, `*`, `/`.
- Division is **real division** (e.g., `4 / (1 - 2 / 3) = 12`).

Return `true` if you can get `24`, otherwise return `false`.

---

## Examples

**Example 1:**
```
Input:  cards = [4,1,8,7]
Output: true
Explanation: (8-4)*(7-1) = 24
```

**Example 2:**
```
Input:  cards = [1,2,1,2]
Output: false
```

---

## Constraints

- `cards.length == 4`
- `1 <= cards[i] <= 9`
