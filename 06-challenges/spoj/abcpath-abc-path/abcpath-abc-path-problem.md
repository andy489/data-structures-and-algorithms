# ABCPATH. ABC Path

**Tags:** no tags
**Link:** https://www.spoj.com/problems/ABCPATH/

---

## Problem Statement

You will be given a 2-dimensional grid of letters. Find the length of the longest path of consecutive letters, starting at 'A'. Paths can step from one letter in the grid to any adjacent letter (horizontally, vertically, or diagonally).

For example, in the following grid, there are several paths from 'A' to 'D', but none from 'A' to 'E':

```
A B E
C F G
B D H
A B C
```

One such path is: `A → B → C → D` (stepping diagonally from A at (0,0) to B at (0,1), then diagonally to C at (1,0), then diagonally to D at (2,1)).

---

## Input Format

Each test case starts with a line containing two integers H and W — the height and width of the grid (1 ≤ H, W ≤ 50). Then H lines follow, each containing W uppercase letters. Input terminates with H = 0 and W = 0.

---

## Output Format

For each test case print `Case C: X` where C is the case number starting with 1 and X is the solution (the length of the longest consecutive-letter path starting at 'A').

---

## Example

**Sample Input:**
```
4 3
ABE
CFG
BDH
ABC
0 0
```

**Sample Output:**
```
Case 1: 4
```

---

## Constraints

- 1 ≤ H, W ≤ 50
- Grid contains uppercase letters only
- Input ends with `0 0`
