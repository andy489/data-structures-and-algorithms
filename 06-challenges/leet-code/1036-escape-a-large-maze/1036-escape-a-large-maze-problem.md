# 1036. Escape a Large Maze

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/escape-a-large-maze/

---

## Problem Statement

There is a 1 million × 1 million grid. We have a `source` point and a `target` point and a list of `blocked` squares.

Return `true` if and only if it is possible to escape the maze from `source` to `target` through squares that are not `blocked`.

---

## Examples

**Example 1:**
```
Input:  blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
Output: false
```

**Example 2:**
```
Input:  blocked = [], source = [0,0], target = [999999,999999]
Output: true
```

---

## Constraints

- `0 <= blocked.length <= 200`
- `blocked[i].length == 2`
- `0 <= blocked[i][0], blocked[i][1] < 10^6`
- `source.length == target.length == 2`
- `source != target`
