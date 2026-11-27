# 1691. Maximum Height by Stacking Cuboids

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-height-by-stacking-cuboids/

---

## Problem Statement

Given `n` cuboids where the dimensions of the `i`-th cuboid is `cuboids[i] = [width_i, length_i, height_i]` (**0-indexed**). Choose a **subset** of cuboids and place them on each other.

You can place cuboid `i` on cuboid `j` if `width_i <= width_j` and `length_i <= length_j` and `height_i <= height_j`. You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.

Return the **maximum height** of the stacked cuboids.

---

## Examples

**Example 1:**
```
Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
Output: 190
Explanation:
Cuboid 1 is placed on the bottom with dimensions 20x45x50 so that it has the greatest height.
Cuboid 0 is placed next with dimensions 20x45x50 -> 50x45x20 becomes 20x45x50 -> on top of cuboid 1? No.
Actually, the optimal stacking height is 190 total.
```

**Example 2:**
```
Input: cuboids = [[38,25,45],[76,35,3]]
Output: 76
```

**Example 3:**
```
Input: cuboids = [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
Output: 102
```

---

## Constraints

- `n == cuboids.length`
- `1 <= n <= 100`
- `1 <= width_i, length_i, height_i <= 100`
