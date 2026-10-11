# 429A. Xor-tree

**Rating:** 1300  
**Tags:** dfs and similar, trees  
**Link:** https://codeforces.com/problemset/problem/429/A

---

## Problem Statement

Iahub has a rooted tree with *n* nodes (numbered 1 to *n*, rooted at node 1). Each node has an **initial value** and a **goal value**, both binary (0 or 1).

An **operation** on node *x* toggles the values at alternating depth levels in its subtree:
- Node *x* itself: flipped
- Children of *x*: unchanged
- Grandchildren of *x*: flipped
- Great-grandchildren: unchanged
- … (alternating by level)

Find the **minimum number of operations** to transform all nodes from their initial values to their goal values.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 10⁵)
- Lines 2 to *n*: pairs of integers *u v* defining tree edges
- Line *n*+1: *n* integers — initial values (0 or 1)
- Line *n*+2: *n* integers — goal values (0 or 1)

---

## Output Format

- Line 1: integer *cnt* — number of operations
- Lines 2 to *cnt*+1: node indices to operate on (one per line)

---

## Example

**Input:**
```
10
2 1
3 1
4 2
5 2
6 3
7 3
8 4
9 5
10 6
1 0 1 1 0 1 0 1 0 1
1 0 1 0 0 1 1 1 0 1
```

**Output:**
```
2
4
7
```

---

## Constraints

- 1 ≤ *n* ≤ 10⁵
- Time limit: 2 seconds, Memory limit: 256 MB
