# 802J. Send the Fool Further! (easy)

**Rating:** 1400  
**Tags:** dfs and similar, graphs, trees  
**Link:** https://codeforces.com/problemset/problem/802/J

---

## Problem Statement

A fool starts at vertex **1** of a rooted tree with *n* vertices. At each step the fool moves to one of the current node's **children**, chosen uniformly at random. The fool stops at a **leaf**.

Compute the **expected number of steps** the fool takes to reach a leaf.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 10⁵)
- Next *n* − 1 lines: pairs *u v* representing tree edges (tree is rooted at vertex 1)

---

## Output Format

A single floating-point number — the expected number of steps. Accepted with absolute or relative error ≤ 10⁻⁶.

---

## Constraints

- 1 ≤ *n* ≤ 10⁵
- Time limit: 2 seconds, Memory limit: 256 MB
