# 913B. Christmas Spruce

**Rating:** 1200  
**Tags:** implementation, trees  
**Link:** https://codeforces.com/problemset/problem/913/B

---

## Problem Statement

A rooted tree (rooted at vertex 1) is called a **spruce** if every **non-leaf** vertex has **at least 3 leaf children**.

A **leaf** is a vertex with no children (but with a parent). The root can also be a leaf if it has no children (but *n* ≥ 3, so this won't happen in practice).

Given a rooted tree, determine whether it is a spruce.

---

## Input Format

- Line 1: integer *n* (3 ≤ *n* ≤ 1000)
- Next *n* − 1 lines: integer *pᵢ* — parent of vertex *i* (for *i* = 2 to *n*)

---

## Output Format

Print `Yes` if the tree is a spruce, `No` otherwise.

---

## Examples

**Example 1:**
```
Input:
4
1 1 1

Output:
Yes
```
Root 1 has 3 leaf children (2, 3, 4).

**Example 2:**
```
Input:
7
1 1 1 2 2 2

Output:
No
```
Root 1 has only 2 leaf children (2 is not a leaf since it has children).

**Example 3:**
```
Input:
8
1 1 1 1 3 3 3

Output:
Yes
```
Root 1 has 3 leaf children (2, 4, 5) and non-leaf child 3. Vertex 3 has 3 leaf children (6, 7, 8).

---

## Constraints

- 3 ≤ *n* ≤ 1000
- Time limit: 1 second, Memory limit: 256 MB
