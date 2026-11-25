# 904. Fruit Into Baskets

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/fruit-into-baskets/

---

## Problem Statement

You are visiting a farm that has a row of `n` trees with fruits. The trees are represented by an integer array `fruits` where `fruits[i]` is the type of fruit the `i`th tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules:
- You only have **two** baskets, and each basket can only hold a **single type** of fruit.
- Once you pick a fruit from a tree, all fruits on the remaining trees must be from the same type or the other type.

Return the **maximum** number of fruits you can pick.

---

## Examples

**Example 1:**
```
Input:  fruits = [1,2,1]
Output: 3
```

**Example 2:**
```
Input:  fruits = [0,1,2,2]
Output: 3
```

---

## Constraints

- `1 <= fruits.length <= 10^5`
- `0 <= fruits[i] < fruits.length`
