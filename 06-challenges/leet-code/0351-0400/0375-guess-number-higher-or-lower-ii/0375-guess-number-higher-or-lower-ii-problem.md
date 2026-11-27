# 375. Guess Number Higher or Lower II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/guess-number-higher-or-lower-ii/

---

## Problem Statement

We are playing the Guessing Game. The game will work as follows:

1. I pick a number between `1` and `n`.
2. You guess a number.
3. If you guess the right number, **you win the game**.
4. If you guess the wrong number, then I will tell you whether the number I picked is **higher** or **lower**, and you will continue guessing.
5. Every time you guess a wrong number `x`, you will pay `x` dollars. If you run out of money, **you lose the game**.

Given a particular `n`, return the minimum amount of money you need to **guarantee a win** regardless of what number I pick.

---

## Examples

**Example 1:**
```
Input:  n = 10
Output: 16
```

**Example 2:**
```
Input:  n = 1
Output: 0
```

**Example 3:**
```
Input:  n = 2
Output: 1
```

---

## Constraints

- `1 <= n <= 200`
