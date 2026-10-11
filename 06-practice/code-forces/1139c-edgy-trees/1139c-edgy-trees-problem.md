# 1139C. Edgy Trees

**Rating:** 1500  
**Tags:** dfs and similar, dsu, graphs, math, trees  
**Link:** https://codeforces.com/problemset/problem/1139/C

---

## Problem Statement

Given a tree with *n* vertices where each of the *n* − 1 edges is colored **black** (1) or **red** (0), and an integer *k*, count sequences of *k* vertices `[a₁, a₂, ..., aₖ]` that are **good**.

A sequence is **good** if traveling the unique paths `a₁→a₂`, `a₂→a₃`, ..., `aₖ₋₁→aₖ` traverses **at least one black edge** in total.

Output the count modulo 10⁹ + 7.

---

## Input Format

- Line 1: integers *n* and *k* (2 ≤ *n* ≤ 10⁵, 2 ≤ *k* ≤ 100)
- Next *n* − 1 lines: integers *uᵢ*, *vᵢ*, *xᵢ* — edge between *uᵢ* and *vᵢ* with color *xᵢ* ∈ {0, 1}

---

## Output Format

Single integer — number of good sequences modulo 10⁹ + 7.

---

## Examples

**Example 1:**
```
Input:
4 4
1 2 1
2 3 1
3 4 1

Output:
252
```

**Example 2:**
```
Input:
4 6
1 2 0
1 3 0
1 4 0

Output:
0
```

**Example 3:**
```
Input:
3 5
1 2 1
2 3 0

Output:
210
```

---

## Constraints

- 2 ≤ *n* ≤ 10⁵, 2 ≤ *k* ≤ 100
- Time limit: 2 seconds, Memory limit: 256 MB
