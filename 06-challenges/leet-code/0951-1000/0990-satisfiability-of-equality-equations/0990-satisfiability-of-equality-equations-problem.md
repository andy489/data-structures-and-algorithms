# 990. Satisfiability of Equality Equations

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/satisfiability-of-equality-equations/

---

## Problem Statement

You are given an array of strings `equations` that represent relationships between variables where each string `equations[i]` is of length 4 and takes one of two different forms: `"xi==yi"` or `"xi!=yi"`.Here, `xi` and `yi` are lowercase letters (not necessarily different) that represent one-letter variable names.

Return `true` if it is possible to assign integers to variable names so as to satisfy all the given equations, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  equations = ["a==b","b!=a"]
Output: false
```

**Example 2:**
```
Input:  equations = ["b==a","a==b"]
Output: true
```

---

## Constraints

- `1 <= equations.length <= 500`
- `equations[i].length == 4`
- `equations[i][0]` is a lowercase letter.
- `equations[i][1]` is either `'='` or `'!'`.
- `equations[i][2] == '='`
- `equations[i][3]` is a lowercase letter.
