# 808. Soup Servings

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/soup-servings/

---

## Problem Statement

There are two types of soup: type A and type B. Initially we have `n` ml of each type. There are four kinds of operations (each chosen with equal probability 1/4):

1. Serve 100 ml of soup A and 0 ml of soup B
2. Serve 75 ml of soup A and 25 ml of soup B
3. Serve 50 ml of soup A and 50 ml of soup B
4. Serve 25 ml of soup A and 75 ml of soup B

When we serve some soup, we serve as much as we can. We stop once we run out of soup A or B (or both simultaneously).

Return the probability that soup A will be empty first, plus half the probability that A and B become empty at the same time.

---

## Examples

**Example 1:**
```
Input:  n = 50
Output: 0.62500
```

**Example 2:**
```
Input:  n = 100
Output: 0.71875
```

---

## Constraints

- `0 <= n <= 10^9`
