# 120F. Spiders

**Rating:** 1400  
**Tags:** dp, greedy, trees  
**Link:** https://codeforces.com/problemset/problem/120/F

---

## Problem Statement

Petya has *n* toy spiders. Each spider is a tree where nodes are **beads** and edges are **threads** of length 1. Petya can glue spiders together by **merging** beads from different spiders (identified nodes become one). The resulting construction must also be a valid spider (a tree). Petya wants to **maximize the diameter** of the final construction.

The **diameter** is the largest distance between any two beads in the final structure.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 100) — number of spiders
- For each spider *i*:
  - Line 1: integer *nᵢ* (2 ≤ *nᵢ* ≤ 100) — number of beads
  - Next *nᵢ* − 1 lines: pairs of integers representing thread connections

---

## Output Format

Single integer — maximum possible diameter of the combined spider.

---

## Examples

**Example 1:**
```
Input:
1
3 1 2 2 3

Output:
2
```

**Example 2:**
```
Input:
2
3 1 2 1 3
4 1 2 2 3 2 4

Output:
4
```

**Example 3:**
```
Input:
2
5 1 2 2 3 3 4 3 5
7 3 4 1 2 2 4 4 6 2 7 6 5

Output:
7
```

---

## Constraints

- 1 ≤ *n* ≤ 100
- 2 ≤ *nᵢ* ≤ 100
- Time limit: 1 second, Memory limit: 256 MB
