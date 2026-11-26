# 1595. Minimum Cost to Connect Two Groups of Points

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/

---

## Problem Statement

You are given two groups of points where the first group has `size1` points, the second group has `size2` points, and `size1 >= size2`.

The `cost` of the connection between any two points are given in an `size1 x size2` matrix where `cost[i][j]` is the cost of connecting point `i` of the first group and point `j` of the second group. The groups are connected if **every point in both groups is connected to one or more points in the other group**. In other words, every point in the first group must be connected to at least one point in the second group, and every point in the second group must be connected to at least one point in the first group.

Return the **minimum cost** it takes to connect the two groups.

---

## Examples

**Example 1:**
```
Input:  cost = [[15,96],[36,2]]
Output: 17
```

**Example 2:**
```
Input:  cost = [[1,3,5],[4,1,1],[1,5,3]]
Output: 4
```

**Example 3:**
```
Input:  cost = [[2,5,1],[3,4,7],[8,1,2],[6,2,4],[3,8,8]]
Output: 10
```

---

## Constraints

- `size1 == cost.length`
- `size2 == cost[i].length`
- `1 <= size1, size2 <= 12`
- `size1 >= size2`
- `0 <= cost[i][j] <= 100`
