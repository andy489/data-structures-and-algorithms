# 838. Push Dominoes

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/push-dominoes/

---

## Problem Statement

There are `n` dominoes in a line, each with one of three states: `'L'`, `'R'`, or `'.'`. Each second, any domino pushed by an adjacent domino also falls. After all dominoes have finished falling, return a string representing the final state of the dominoes.

---

## Examples

**Example 1:**
```
Input:  dominoes = "RR.L"
Output: "RR.L"
```

**Example 2:**
```
Input:  dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
```

---

## Constraints

- `n == dominoes.length`
- `1 <= n <= 10^5`
- `dominoes[i]` is either `'L'`, `'R'`, or `'.'`.
