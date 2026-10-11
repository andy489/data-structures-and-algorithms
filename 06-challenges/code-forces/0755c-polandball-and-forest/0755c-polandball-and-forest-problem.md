# 755C. PolandBall and Forest

**Rating:** 1300  
**Tags:** dfs and similar, dsu, graphs, trees  
**Link:** https://codeforces.com/problemset/problem/755/C

---

## Problem Statement

PolandBall's family lives in a **forest** (collection of trees) with *n* nodes, each with a unique ID from 1 to *n*.

For each node *i*, you are given *pᵢ*: the ID of its **most distant relative** on the same tree (if there are ties, the one with the smallest ID).

Determine the **number of trees** in the forest.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 10⁴)
- Line 2: integers *p₁, p₂, ..., pₙ*

---

## Output Format

Single integer — number of trees.

---

## Examples

**Example 1:**
```
Input:
5
2 1 5 3 3

Output:
2
```
Forest: tree `1-2` and tree `3-4-5`.

**Example 2:**
```
Input:
1
1

Output:
1
```
Single isolated vertex.

---

## Constraints

- 1 ≤ *n* ≤ 10⁴
- 1 ≤ *pᵢ* ≤ *n*
- Time limit: 2 seconds, Memory limit: 256 MB
