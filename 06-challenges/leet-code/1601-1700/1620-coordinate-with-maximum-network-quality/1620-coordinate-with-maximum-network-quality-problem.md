# 1620. Coordinate With Maximum Network Quality

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/coordinate-with-maximum-network-quality/

---

## Problem Statement

You are given an array of network towers `towers`, where `towers[i] = [xi, yi, qi]` denotes the `i`th network tower with location `(xi, yi)` and quality factor `qi`. All the coordinates are **integral coordinates** on the X-Y plane, and two coordinates are the same if they have the same X and Y values.

The integer distance between two coordinates is the **Euclidean distance** (not rounded).

You are also given an integer `radius` where a tower is **reachable** if the distance is **at most** `radius`. Outside that distance, the signal quality is `0`.

The signal quality of the `i`th tower at a coordinate `(x, y)` is calculated with the formula `⌊qi / (1 + d)⌋`, where `d` is the distance between the tower and the coordinate.

The **network quality** at a coordinate is the sum of the signal qualities from all reachable towers.

Return the array `[cx, cy]` representing the **integral coordinate** `(cx, cy)` where the network quality is maximum. If there are multiple coordinates with the same network quality, return the lexicographically minimum non-negative coordinate.

---

## Examples

**Example 1:**
```
Input: towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
Output: [2,2]
```

**Example 2:**
```
Input: towers = [[23,11,21]], radius = 9
Output: [23,11]
```

**Example 3:**
```
Input: towers = [[1,2,13],[2,2,13]], radius = 3
Output: [2,2]
```

---

## Constraints
- `1 <= towers.length <= 50`
- `0 <= xi, yi, qi <= 50`
- `1 <= radius <= 50`
