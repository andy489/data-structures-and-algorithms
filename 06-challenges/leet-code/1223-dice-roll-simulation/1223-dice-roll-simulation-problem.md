# 1223. Dice Roll Simulation

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/dice-roll-simulation/

---

## Problem Statement

A die simulator generates a random number from `1` to `6` for each roll. You introduced a constraint to the generator such that it cannot roll the number `i` more than `rollMax[i]` (1-indexed) consecutive times.

Given an array of integers `rollMax` and an integer `n`, return the number of distinct sequences that can be obtained with exact `n` rolls. Answer may be large, return it modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  n = 2, rollMax = [1,1,2,2,2,3]
Output: 34
```

---

## Constraints

- `1 <= n <= 5000`
- `rollMax.length == 6`
- `1 <= rollMax[i] <= 15`
