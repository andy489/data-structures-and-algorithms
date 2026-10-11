# 115A. Party

**Rating:** 900  
**Tags:** dfs and similar, graphs, trees  
**Link:** https://codeforces.com/problemset/problem/115/A

---

## Problem Statement

A company has *n* employees. Each employee has either no manager or exactly one immediate manager. Employee A is a **superior** of employee B if A is B's manager, or A is a superior of B's manager (transitive).

The company wants to split all employees into the **minimum number of groups** such that no group contains two employees where one is a superior of the other.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 2000)
- Next *n* lines: integer *pᵢ* — the immediate manager of employee *i*, or `-1` if employee *i* has no manager

---

## Output Format

Single integer — the minimum number of groups.

---

## Example

**Input:**
```
5
-1
1
2
1
-1
```

**Output:**
```
3
```

**Explanation:** The longest chain in the hierarchy is `5 → 1 → 2 → 3` (length 3). One valid grouping: `{1, 5}`, `{2, 4}`, `{3}`.

---

## Notes

- There can be multiple roots (employees with no manager), forming a **forest**.
- The minimum number of groups equals the **maximum depth** (longest root-to-leaf path) across all trees in the forest.
