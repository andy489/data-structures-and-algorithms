# 675. Cut Off Trees for Golf Event

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cut-off-trees-for-golf-event/

---

## Problem Statement

You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an `m x n` matrix. In this matrix:

- `0` means the cell cannot be walked through.
- `1` means the cell can be walked through but has no tree.
- A value greater than `1` represents a tree with that value as the tree's height.

In one step you can walk in any of the four directions: north, east, south, or west. If you are standing in a cell with a tree, you can choose whether to cut it off.

You must cut off the trees in order from shortest to tallest. When you cut off a tree, the value at its cell becomes `1` (walked through).

Starting from the point `(0, 0)`, return the minimum steps you need to walk to cut off all the trees. If you cannot cut off all the trees, return `-1`.

---

## Examples

**Example 1:**
```
Input:  forest = [[1,2,3],[0,0,4],[7,6,5]]
Output: 6
```

**Example 2:**
```
Input:  forest = [[1,2,3],[0,0,0],[7,6,5]]
Output: -1
```

**Example 3:**
```
Input:  forest = [[2,3,4],[0,0,5],[8,7,6]]
Output: 6
Explanation: You start at (0,0) and must cut trees in this order: 2→3→4→5→6→7→8.
```

---

## Constraints

- `m == forest.length`
- `n == forest[i].length`
- `1 <= m, n <= 50`
- `0 <= forest[i][j] <= 10⁹`
