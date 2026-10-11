# 1143C. Queen

**Rating:** 1400  
**Tags:** dfs and similar, trees  
**Link:** https://codeforces.com/problemset/problem/1143/C

---

## Problem Statement

Given a rooted tree with *n* vertices, each vertex *i* has a parent *pᵢ* and a **respect value** *cᵢ* ∈ {0, 1}:
- *cᵢ* = 1: vertex *i* does **not** respect any of its ancestors.
- *cᵢ* = 0: vertex *i* **respects** all its ancestors.

Repeatedly delete the **smallest-numbered** non-root vertex satisfying **all** of the following:
1. *cᵢ* = 1 (it does not respect its parent).
2. None of its current children respect it (all children have *cⱼ* = 1).

When a vertex *v* is deleted, all its children become children of *v*'s parent.

Repeat until no deletable vertex exists. Output the deleted vertices in deletion order, or `-1` if none.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 10⁵)
- Next *n* lines: *pᵢ* and *cᵢ* for vertex *i*
  - Root: *pᵢ* = −1, *cᵢ* = 0
  - Others: 1 ≤ *pᵢ* ≤ *n*, *cᵢ* ∈ {0, 1}

---

## Output Format

Indices of deleted vertices in deletion order, or `-1` if none.

---

## Examples

**Example 1:**
```
Input:
5
3 1
1 1
-1 0
2 1
3 0

Output:
1 2 4
```

**Example 2:**
```
Input:
5
-1 0
1 1
1 1
2 0
3 0

Output:
-1
```

**Example 3:**
```
Input:
8
2 1
-1 0
1 0
1 1
1 1
4 0
5 1
7 0

Output:
5
```

---

## Constraints

- 1 ≤ *n* ≤ 10⁵
- Time limit: 2 seconds, Memory limit: 256 MB
