# 1753. Maximum Score from Removing Stones

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-score-from-removing-stones/

---

## Problem Statement

You are playing a solitaire game with **three piles** of stones of sizes `a`, `b`, and `c` respectively. Each turn you choose two **different non-empty** piles, take one stone from each, and add `1` point to your score. The game stops when there are fewer than two non-empty piles (meaning all stones are in a single pile or everything is empty).

Given three integers `a`, `b`, and `c`, return the **maximum** score you can get.

---

## Examples

**Example 1:**
```
Input: a = 2, b = 4, c = 6
Output: 6
Explanation: Use first and third piles: 2+2+2 = 6, then use second and third: 2+2 = 4. Total = 6.
```

**Example 2:**
```
Input: a = 4, b = 4, c = 6
Output: 7
```

**Example 3:**
```
Input: a = 1, b = 8, c = 8
Output: 8
```

---

## Constraints

- `1 <= a, b, c <= 10^5`
