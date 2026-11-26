# 391. Perfect Rectangle

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/perfect-rectangle/

---

## Problem Statement

Given an array `rectangles` where `rectangles[i] = [xi, yi, ai, bi]` represents an axis-aligned rectangle. The bottom-left point of the `i`th rectangle is `(xi, yi)` and the top-right point is `(ai, bi)`.

Return `true` if all the rectangles together form an exact cover of a rectangular region.

---

## Examples

**Example 1:**
```
Input:  rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
Output: true
Explanation: All 5 rectangles together form an exact cover of a rectangular region.
```

**Example 2:**
```
Input:  rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
Output: false
Explanation: There is a gap between the two rectangular regions.
```

**Example 3:**
```
Input:  rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
Output: false
Explanation: Two rectangles overlap with each other.
```

---

## Constraints

- `1 <= rectangles.length <= 2 * 10^4`
- `rectangles[i].length == 4`
- `-10^5 <= xi < ai <= 10^5`
- `-10^5 <= yi < bi <= 10^5`
