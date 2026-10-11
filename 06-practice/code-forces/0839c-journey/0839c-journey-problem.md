# 839C. Journey

**Rating:** 1500  
**Tags:** dfs and similar, dp, graphs, probabilities, trees  
**Link:** https://codeforces.com/problemset/problem/839/C

---

## Problem Statement

Two travelers start at city **1** of a tree with *n* cities connected by *n* − 1 roads. Their horse moves randomly: at each step it goes to one of the **unvisited neighboring cities** with equal probability. The journey ends when there are no unvisited neighbors left (i.e., the horse reaches a leaf of the tree from the current path).

Compute the **expected length** of their journey.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 100,000) — number of cities
- Next *n* − 1 lines: pairs *uᵢ vᵢ* — roads connecting cities

---

## Output Format

A single floating-point number — the expected journey length. Accepted with absolute or relative error ≤ 10⁻⁶.

---

## Examples

**Example 1:**
```
Input:
4
1 2
1 3
2 4

Output:
1.500000000000000
```
From city 1: go to city 2 (prob 1/2) then city 4 (distance 2), or go to city 3 (prob 1/2, distance 1). Expected = 0.5·2 + 0.5·1 = 1.5.

**Example 2:**
```
Input:
5
1 2
1 3
3 4
2 5

Output:
2.000000000000000
```

---

## Constraints

- 1 ≤ *n* ≤ 10⁵
- Time limit: 2 seconds, Memory limit: 256 MB
