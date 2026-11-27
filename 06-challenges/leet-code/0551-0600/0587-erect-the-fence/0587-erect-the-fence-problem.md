# 587. Erect the Fence

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/erect-the-fence/

---

## Problem Statement

You are given an array `trees` where `trees[i] = [xi, yi]` represents the location of a tree in the garden.

Fence the entire garden using the **minimum amount of rope** as it is expensive. The garden is well-fenced only if **all the trees are enclosed**.

Return the coordinates of trees that are **exactly on the fence perimeter**. You may return the answer in **any order**.

---

## Examples

**Example 1:**
```
Input:  trees = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]
```

**Example 2:**
```
Input:  trees = [[1,2],[2,2],[4,2]]
Output: [[4,2],[2,2],[1,2]]
```

---

## Constraints

- `1 <= trees.length <= 3000`
- `trees[i].length == 2`
- `0 <= xi, yi <= 100`
- All the given positions are **unique**.
