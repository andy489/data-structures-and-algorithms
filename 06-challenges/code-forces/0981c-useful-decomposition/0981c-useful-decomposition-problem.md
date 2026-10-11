# 981C. Useful Decomposition

**Rating:** 1400  
**Tags:** implementation, trees  
**Link:** https://codeforces.com/problemset/problem/981/C

---

## Problem Statement

Given a tree with *n* vertices, decompose its edges into **simple paths** such that:
1. Every two paths in the decomposition share **at least one common vertex**.
2. Each edge belongs to **exactly one path**.

If a valid decomposition exists, output it. Otherwise output `No`.

---

## Input Format

- Line 1: integer *n* (2 ≤ *n* ≤ 10⁵)
- Next *n* − 1 lines: pairs *aᵢ bᵢ* representing edges

---

## Output Format

- Line 1: `Yes` or `No`
- If `Yes`:
  - Line 2: integer *m* — number of paths
  - Next *m* lines: pairs *uᵢ vᵢ* — endpoints of each path

---

## Examples

**Example 1:**
```
Input:
4
1 2
2 3
3 4

Output:
Yes
1
1 4
```

**Example 2:**
```
Input:
6
1 2
2 3
3 4
2 5
3 6

Output:
No
```

**Example 3:**
```
Input:
5
1 2
1 3
1 4
1 5

Output:
Yes
4
1 2
1 3
1 4
1 5
```

---

## Constraints

- 2 ≤ *n* ≤ 10⁵
- Time limit: 2 seconds, Memory limit: 256 MB
