# 914. X of a Kind in a Deck of Cards

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

---

## Problem Statement

You are given an integer array `deck` where `deck[i]` represents the number written on the `i`th card.

Partition the cards into **one or more groups** such that:
- Each group has **exactly** `x` cards where `x >= 2`.
- All the cards in one group have the same integer written on them.

Return `true` if such a partition is possible, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  deck = [1,2,3,4,4,3,2,1]
Output: true
```

**Example 2:**
```
Input:  deck = [1,1,1,2,2,2,3,3]
Output: false
```

---

## Constraints

- `1 <= deck.length <= 10^4`
- `0 <= deck[i] < 10^4`
