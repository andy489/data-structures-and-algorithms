# 749. Contain Virus

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/contain-virus/

---

## Problem Statement

A virus is spreading rapidly, and your task is to quarantine the infected area by installing walls.

The world is modeled as an `m x n` binary grid `isInfected`, where `isInfected[i][j] == 0` represents uninfected cells and `isInfected[i][j] == 1` represents cells infected with the virus. A wall (and only a wall) can be installed between any two **4-directionally adjacent** cells, on the border between them.

Every night, the virus spreads to all neighboring cells in four directions unless blocked by a wall.

You should install walls to stop the virus. Each morning, you can install walls around only one region — you should contain the **threat** (the region that would infect the most uninfected cells the next night).

Return the number of walls used.

---

## Examples

**Example 1:**
```
Input:  isInfected = [[0,1,0,0,0,0,0,1],[0,1,0,0,0,0,0,1],[0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0]]
Output: 10
```

---

## Constraints

- `m == isInfected.length`
- `n == isInfected[i].length`
- `1 <= m, n <= 50`
- `isInfected[i][j]` is either `0` or `1`.
- There is always a contiguous viral region throughout the described process that will **infect strictly more uninfected squares** in the next round.
