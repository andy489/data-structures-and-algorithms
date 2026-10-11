# 1057A. Bmail Computer Network

**Rating:** 900  
**Tags:** dfs and similar, trees, special problem  
**Link:** https://codeforces.com/problemset/problem/1057/A

---

## Problem Statement

A company built a network of *n* routers over time. When each new router *i* was purchased, it was connected to one previously purchased router *pᵢ* (where *pᵢ* < *i*). This forms a **rooted tree** with router 1 as the root.

Find and output the **path from router 1 to router *n***.

---

## Input Format

- Line 1: integer *n* (2 ≤ *n* ≤ 200,000)
- Line 2: integers *p₂, p₃, ..., pₙ* — parent of each router (*pᵢ* < *i*)

---

## Output Format

The sequence of routers on the path from router 1 to router *n*, in order.

---

## Examples

**Example 1:**
```
Input:
8
1 1 2 2 3 2 5

Output:
1 2 5 8
```

**Example 2:**
```
Input:
6
1 2 3 4 5

Output:
1 2 3 4 5 6
```

**Example 3:**
```
Input:
7
1 1 2 3 4 3

Output:
1 3 7
```

---

## Constraints

- 2 ≤ *n* ≤ 200,000
- 1 ≤ *pᵢ* < *i*
- Time limit: 1 second, Memory limit: 256 MB
