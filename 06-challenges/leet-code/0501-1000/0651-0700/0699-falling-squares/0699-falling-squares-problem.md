# 699. Falling Squares

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/falling-squares/

---

## Problem Statement

There are several squares being dropped onto the X-axis of a 2D plane.

You are given a 2D integer array `positions` where `positions[i] = [lefti, sideLengthi]` represents the `i`th square with a side length of `sideLengthi` that is dropped with its left edge aligned with X-coordinate `lefti`.

Each square is dropped one at a time from a height above any landed squares. It then falls until it either lands on the **top side of another square** or on the **X-axis**. A square brushing the left/right side of another square does not count as landing on it.

After each square is placed, return a list of the **heights** of the tallest stack of squares so far.

---

## Examples

**Example 1:**
```
Input:  positions = [[1,2],[2,3],[6,1]]
Output: [2,5,5]
```

**Example 2:**
```
Input:  positions = [[100,100],[200,100]]
Output: [100,200]
```

---

## Constraints

- `1 <= positions.length <= 1000`
- `1 <= lefti <= 10⁸`
- `1 <= sideLengthi <= 10⁶`
