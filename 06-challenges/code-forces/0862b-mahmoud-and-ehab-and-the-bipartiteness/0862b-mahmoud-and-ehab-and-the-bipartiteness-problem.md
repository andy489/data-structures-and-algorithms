# 862B. Mahmoud and Ehab and the Bipartiteness

**Rating:** 1300  
**Tags:** dfs and similar, graphs, trees  
**Link:** https://codeforces.com/problemset/problem/862/B

---

## Problem Statement

Given a tree with *n* nodes, find the **maximum number of edges** that can be added to it while keeping the graph:
1. **Bipartite** (no odd cycles)
2. **Simple** (no loops or multi-edges)

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 10⁵)
- Next *n* − 1 lines: pairs *u v* — tree edges

---

## Output Format

Single integer — maximum number of edges that can be added.

---

## Examples

**Example 1:**
```
Input:
3
1 2
1 3

Output:
0
```

**Example 2:**
```
Input:
5
1 2
2 3
3 4
4 5

Output:
2
```
Edges (1,4) and (2,5) can be added.

---

## Constraints

- 1 ≤ *n* ≤ 10⁵
- Time limit: 2 seconds, Memory limit: 256 MB
