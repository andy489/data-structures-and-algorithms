# 1648. Sell Diminishing-Valued Colored Balls

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sell-diminishing-valued-colored-balls/

---

## Problem Statement

You have an `inventory` of different colored balls, and there is a customer that wants `orders` balls.

The customer weirdly values the colored balls. Each colored ball's value is the number of that color still remaining **when that ball is sold**. For example, if you sell a ball with 5 of its color left, that ball's value is 5. Then the next ball you sell of that color has value 4, and so on.

Maximize your total value of `orders` sold balls. Return this maximum total value modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input: inventory = [2,5], orders = 4
Output: 14
Explanation: Sell the 1st color 1 time (2) and the 2nd color 3 times (5+4+3=12). Total = 14.
```

**Example 2:**
```
Input: inventory = [3,5], orders = 6
Output: 19
Explanation: Sell the 2nd color 4 times (5+4+3+2=14) and the 1st color 2 times (3+2=5). Total = 19.
```

---

## Constraints

- `1 <= inventory.length <= 10^5`
- `1 <= inventory[i] <= 10^9`
- `1 <= orders <= min(sum(inventory[i]), 10^9)`
