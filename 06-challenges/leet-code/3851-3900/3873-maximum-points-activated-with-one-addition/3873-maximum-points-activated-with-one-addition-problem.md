# 3873. Maximum Points Activated with One Addition

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-points-activated-with-one-addition/

## Problem

You are given a 2D integer array `points`, where `points[i] = [xi, yi]` represents the coordinates of the `i`th point. All coordinates in `points` are **distinct**.

If a point is **activated**, then all points that have the **same** x-coordinate **or** y-coordinate become **activated** as well.

Activation continues until no additional points can be activated.

You may add **one additional** point at any integer coordinate `(x, y)` not already present in `points`. Activation begins by **activating** this **newly added point**.

Return an integer denoting the **maximum** number of points that can be activated, including the newly added point.

## Examples

**Example 1:**
```
Input: points = [[1,1],[1,2],[2,2]]
Output: 4
Explanation:
Adding and activating a point such as (1, 3) causes activations:
- (1, 3) shares x = 1 with (1, 1) and (1, 2) -> (1, 1) and (1, 2) become activated.
- (1, 2) shares y = 2 with (2, 2) -> (2, 2) becomes activated.
Thus, the activated points are (1, 3), (1, 1), (1, 2), (2, 2), so 4 points in total.
```

**Example 2:**
```
Input: points = [[2,2],[1,1],[3,3]]
Output: 2
Explanation:
Adding any point activates at most one existing point (via shared x or y).
```

## Constraints

- `1 <= points.length <= 10^5`
- `0 <= xi, yi <= 10^9`
- All coordinates in points are distinct.
