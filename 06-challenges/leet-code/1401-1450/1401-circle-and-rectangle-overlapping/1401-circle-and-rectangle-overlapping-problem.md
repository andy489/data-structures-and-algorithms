# 1401. Circle And Rectangle Overlapping

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/circle-and-rectangle-overlapping/

---

## Problem Statement

Given a circle (center `(xCenter, yCenter)`, `radius`) and an axis-aligned rectangle (bottom-left `(x1,y1)`, top-right `(x2,y2)`), return `true` if they overlap.

---

## Examples

**Example 1:**
```
Input:  xCenter=0,yCenter=0,radius=10,x1=-5,y1=-5,x2=5,y2=5
Output: true
```

**Example 2:**
```
Input:  xCenter=10,yCenter=10,radius=1,x1=-1,y1=-1,x2=1,y2=1
Output: false
```

---

## Constraints

- `-10^4 <= x1 <= x2 <= 10^4`
- `-10^4 <= y1 <= y2 <= 10^4`
- `1 <= radius <= 10^4`
