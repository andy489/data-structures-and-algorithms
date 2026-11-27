# 2209. Minimum White Tiles After Covering With Carpets

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets/

## Problem

You are given a 0-indexed binary string floor, which represents the colors of tiles on a floor:
- floor[i] = '0' denotes that the ith tile of the floor is colored black.
- floor[i] = '1' denotes that the ith tile of the floor is colored white.

You are also given numCarpets and carpetLen. You have numCarpets black carpets, each of length carpetLen tiles. Cover the tiles with the given carpets such that the number of white tiles still visible is minimum. Carpets may overlap one another.

Return the minimum number of white tiles still visible.

## Examples

**Example 1:**
```
Input: floor = "10110101", numCarpets = 2, carpetLen = 2
Output: 2
```

**Example 2:**
```
Input: floor = "11111", numCarpets = 2, carpetLen = 3
Output: 0
```

## Constraints

- 1 <= carpetLen <= floor.length <= 1000
- floor[i] is either '0' or '1'.
- 1 <= numCarpets <= 1000
