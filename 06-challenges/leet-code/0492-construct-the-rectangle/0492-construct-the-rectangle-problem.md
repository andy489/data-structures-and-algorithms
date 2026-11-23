# 492. Construct the Rectangle

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/construct-the-rectangle/

---

## Problem Statement

A web developer needs to know how to design a web page's size. So, given a specific rectangular web page's area, your job by now is to design a rectangular web page, whose length `L` and width `W` satisfy the following requirements:

1. The area of the rectangular web page you designed must equal to the given target area.
2. The width `W` should not be larger than the length `L`, which means `L >= W`.
3. The difference between length `L` and width `W` should be as small as possible.

Return *an array `[L, W]` where `L` and `W` are the length and width of the web page you designed in sequence.*

---

## Examples

**Example 1:**
```
Input:  area = 4
Output: [2, 2]
```

**Example 2:**
```
Input:  area = 37
Output: [37, 1]
```

**Example 3:**
```
Input:  area = 122122
Output: [427, 286]
```

---

## Constraints

- `1 <= area <= 10^7`
