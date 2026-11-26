# 497. Random Point in Non-overlapping Rectangles

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/

---

## Problem Statement

You are given an array of non-overlapping axis-aligned rectangles `rects` where `rects[i] = [ai, bi, xi, yi]` indicates that `(ai, bi)` is the **bottom-left** corner point of the `i`th rectangle and `(xi, yi)` is the **top-right** corner point of the `i`th rectangle. Design an algorithm to pick a **random integer point** inside the space covered by one of the given rectangles. A point on the perimeter of a rectangle is included as a point inside the rectangle.

Any integer point inside the space covered by one of the given rectangles should be **equally likely** to be returned.

**Note** that an integer point is a point that has integer coordinates.

Implement the `Solution` class:

- `Solution(int[][] rects)` Initializes the object with the given rectangles `rects`.
- `int[] pick()` Returns a random integer point `[u, v]` inside the space covered by one of the given rectangles.

---

## Examples

**Example 1:**
```
Input:  ["Solution", "pick", "pick", "pick", "pick", "pick"]
        [[[ [-2,-2,1,1],[2,2,4,4] ]], [], [], [], [], []]
Output: [null, [1,1], [1,-2], [1,-1], [-2,-2], [-2,1]]
```

---

## Constraints

- `1 <= rects.length <= 100`
- `rects[i].length == 4`
- `-10^9 <= ai <= xi <= 10^9`
- `-10^9 <= bi <= yi <= 10^9`
- `xi - ai <= 2000`
- `yi - bi <= 2000`
- All the rectangles do not overlap
- At most `10^4` calls will be made to `pick`
