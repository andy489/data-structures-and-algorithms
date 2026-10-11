# 1325D. Ehab the Xorcist

**Rating:** 1700  
**Tags:** bitmasks, constructive algorithms, greedy, number theory  
**Link:** https://codeforces.com/problemset/problem/1325/D

---

## Problem Statement

Given two integers *u* and *v*, find the **shortest array** of positive integers such that:
- The **bitwise XOR** of all elements equals *u*.
- The **sum** of all elements equals *v*.

If no such array exists, output `-1`.

---

## Input Format

Single line: integers *u* and *v* (0 ≤ *u*, *v* ≤ 10¹⁸).

---

## Output Format

- If impossible: `-1`
- Otherwise:
  - Line 1: integer *n* — length of the array
  - Line 2: *n* positive integers

If multiple solutions exist, any valid answer is accepted.

---

## Examples

| Input | Output | Explanation |
|-------|--------|-------------|
| `2 4` | `2`<br>`3 1` | 3 ⊕ 1 = 2, 3 + 1 = 4 |
| `1 3` | `3`<br>`1 1 1` | 1 ⊕ 1 ⊕ 1 = 1, 1 + 1 + 1 = 3 |
| `8 5` | `-1` | Impossible |
| `0 0` | `0` | Empty array |

---

## Constraints

- 0 ≤ *u*, *v* ≤ 10¹⁸
- Time limit: 1 second, Memory limit: 256 MB
