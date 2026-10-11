# 886C. Petya and Catacombs

**Rating:** 1300  
**Tags:** dsu, greedy, implementation, trees  
**Link:** https://codeforces.com/problemset/problem/886/C

---

## Problem Statement

An explorer visits rooms in catacombs. At each minute *i* (1-indexed), Petya enters a room and writes a note *tᵢ*:
- If he has **visited this room before**: *tᵢ* = the last minute he was in this room.
- If the room is **new**: *tᵢ* can be any non-negative integer less than *i*.

Given the sequence of notes, determine the **minimum possible number of distinct rooms**.

---

## Input Format

- Line 1: integer *n* (1 ≤ *n* ≤ 2·10⁵)
- Line 2: *n* integers *t₁, t₂, ..., tₙ* where 0 ≤ *tᵢ* < *i*

---

## Output Format

Single integer — minimum number of rooms.

---

## Examples

**Example 1:**
```
Input:
2
0 0

Output:
2
```

**Example 2:**
```
Input:
5
0 1 0 1 3

Output:
3
```
One valid path: room 1 → room 2 → room 3 → room 1 → room 2 → room 1.

---

## Constraints

- 1 ≤ *n* ≤ 2·10⁵
- 0 ≤ *tᵢ* < *i*
- Time limit: 1 second, Memory limit: 256 MB
