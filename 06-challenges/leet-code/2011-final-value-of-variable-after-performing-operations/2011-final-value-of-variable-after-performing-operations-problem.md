# 2011. Final Value of Variable After Performing Operations

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

---

## Problem Statement

There is a programming language with only four operations on a single variable `X`:
- `++X` and `X++` increment `X` by 1.
- `--X` and `X--` decrement `X` by 1.

Given an array of operations, return the **final value** of `X` after performing all operations.

---

## Examples

**Example 1:**
```
Input:  operations = ["--X","X++","X++"]
Output: 1
```
Explanation: Start X=0: -1, 0, 1.

**Example 2:**
```
Input:  operations = ["++X","++X","X++"]
Output: 3
```
Explanation: Start X=0: 1, 2, 3.

**Example 3:**
```
Input:  operations = ["X++","++X","--X","X--"]
Output: 0
```

---

## Constraints

- `1 <= operations.length <= 100`
- `operations[i] is one of "++X", "X++", "--X", or "X--".`
