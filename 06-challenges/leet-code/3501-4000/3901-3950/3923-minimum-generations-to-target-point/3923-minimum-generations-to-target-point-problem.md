# 3923. Minimum Generations to Target Point

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/minimum-generations-to-target-point/

## Problem

You are given a 2D integer array `points` where `points[i] = [xi, yi, zi]` represents a point in 3D space, and an integer array `target` representing a target point.

Define **generation** 0 as the initial list of points. For each integer `k >= 1`, form generation `k` as follows:

- Consider every pair of two **distinct** points `a = [x1, y1, z1]` and `b = [x2, y2, z2]` taken from all points produced in generations 0 through `k - 1`.
- For each such pair, compute `c = [floor((x1 + x2) / 2), floor((y1 + y2) / 2), floor((z1 + z2) / 2)]` and collect every such `c` into generation `k`.
- All points in generation `k` are produced **simultaneously** from points in generations 0 through `k - 1`.

Return the **smallest** integer `k` such that the `target` appears in one of the generations 0 through `k`. If the `target` is already in the initial points, return 0. If it is impossible to obtain the `target`, return -1.

**Notes:**
- **floor** denotes rounding **down** to the nearest integer.
- Two **distinct** points means different `(x, y, z)` coordinates; a point cannot be paired with itself.

## Examples

**Example 1:**

```
Input: points = [[0,0,0],[6,6,6]], target = [3,3,3]
Output: 1
```

**Example 2:**

```
Input: points = [[0,0,0],[5,5,5]], target = [1,1,1]
Output: 2
```

**Example 3:**

```
Input: points = [[0,0,0],[2,2,2],[3,3,3]], target = [2,2,2]
Output: 0
```

**Example 4:**

```
Input: points = [[1,2,3]], target = [5,5,5]
Output: -1
Explanation: Only one initial point, so no new points can be generated.
```

## Constraints

- `1 <= points.length <= 20`
- `points[i] = [xi, yi, zi]`
- `0 <= xi, yi, zi <= 6`
- `target.length == 3`
- `0 <= target[i] <= 6`
- The initial set of points contains no duplicates.
