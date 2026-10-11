# 580C. Kefa and Park

**Rating:** 1500  
**Tags:** dfs and similar, graphs, trees  
**Link:** https://codeforces.com/problemset/problem/580/C

---

## Problem Statement

Kefa lives at vertex **1** of a rooted tree with *n* vertices. Some vertices have **cats**. Leaf vertices contain **restaurants**.

Kefa will only visit a restaurant if the path from his home (vertex 1) to that restaurant has **at most *m* consecutive vertices with cats**.

Count the number of **reachable restaurants**.

---

## Input Format

- Line 1: integers *n* and *m* (2 ≤ *n* ≤ 10⁵, 1 ≤ *m* ≤ *n*)
- Line 2: *n* integers *aᵢ* ∈ {0, 1} — 1 if vertex *i* has a cat
- Next *n* − 1 lines: undirected edges *u v*

---

## Output Format

Single integer — number of reachable restaurants.

---

## Examples

**Example 1:**
```
Input:
4 1
1 1 0 0
1 2
1 3
1 4

Output:
2
```
Vertex 2 is a leaf but path 1→2 has 2 consecutive cats — blocked. Vertices 3 and 4 are reachable.

**Example 2:**
```
Input:
7 1
1 0 1 1 0 0 0
1 2
1 3
2 4
2 5
3 6
3 7

Output:
2
```

---

## Constraints

- 2 ≤ *n* ≤ 10⁵
- 1 ≤ *m* ≤ *n*
- Time limit: 2 seconds, Memory limit: 256 MB
