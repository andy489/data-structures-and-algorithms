# 836. Rectangle Overlap

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/rectangle-overlap/

---

## Problem Statement

An axis-aligned rectangle is represented as a list `[x1, y1, x2, y2]`, where `(x1, y1)` is the bottom-left corner, and `(x2, y2)` is the top-right corner. Two rectangles overlap if the area of their intersection is positive. Return `true` if they overlap, `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
```

**Example 2:**
```
Input:  rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
```

---

## Constraints

- `rec1.length == rec2.length == 4`
- `-10^9 <= rec1[i], rec2[i] <= 10^9`
- `rec1` and `rec2` represent a valid rectangle with a non-zero area.
