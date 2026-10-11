# 1325E. Ehab's REAL Number Theory Problem

**Rating:** 2600  
**Tags:** brute force, dfs and similar, graphs, number theory, shortest paths  
**Link:** https://codeforces.com/problemset/problem/1325/E

---

## Problem Statement

Given an array of *n* integers where each element has **at most 7 divisors**, find the **length of the shortest non-empty subsequence** whose product is a **perfect square**.

Output `-1` if no such subsequence exists.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 10⁵)
- Line 2: *n* integers *a₁, a₂, ..., aₙ* (1 ≤ *aᵢ* ≤ 10⁶)

---

## Output Format

Single integer — the length of the shortest valid subsequence, or `-1`.

---

## Examples

| Input | Output | Explanation |
|-------|--------|-------------|
| `3`<br>`1 4 6` | `1` | [1] is a perfect square |
| `4`<br>`2 3 6 6` | `2` | [6, 6]: product = 36 = 6² |
| `3`<br>`6 15 10` | `3` | 6·15·10 = 900 = 30² |
| `4`<br>`2 3 5 7` | `-1` | No subsequence has perfect square product |

---

## Constraints

- 1 ≤ *n* ≤ 10⁵
- 1 ≤ *aᵢ* ≤ 10⁶
- Each *aᵢ* has **at most 7 divisors** (key structural constraint)
- Time limit: 3 seconds, Memory limit: 256 MB
