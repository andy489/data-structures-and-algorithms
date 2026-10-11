# 1325C. Ehab and Path-etic MEXs

**Rating:** 1500  
**Tags:** constructive algorithms, dfs and similar, greedy, trees  
**Link:** https://codeforces.com/problemset/problem/1325/C

---

## Problem Statement

Given a tree with *n* nodes, label its *n* − 1 edges with **distinct** integers from 0 to *n* − 2.

The **MEX(u, v)** of a pair (u, v) is the smallest non-negative integer not present on any edge of the unique path from *u* to *v*.

Minimize the **maximum MEX** over all pairs of nodes.

Output the edge labels (one per edge, in input order).

---

## Input Format

- Line 1: integer *n* (2 ≤ *n* ≤ 10⁵)
- Next *n* − 1 lines: pairs *u v* — edges (in the order they should be labeled)

---

## Output Format

*n* − 1 integers — the label for each edge in the order given.

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
1
```

**Example 2:**
```
Input:
6
1 2
1 3
2 4
2 5
5 6

Output:
0
3
2
4
1
```

---

## Constraints

- 2 ≤ *n* ≤ 10⁵
- Time limit: 1 second, Memory limit: 256 MB
