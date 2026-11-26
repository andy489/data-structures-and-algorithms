# 756. Pyramid Transition Matrix

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/pyramid-transition-matrix/

---

## Problem Statement

We are stacking blocks to form a pyramid. Each block has a color which is a one-letter string.

We are allowed to place any color block `C` on top of two adjacent blocks of colors `A` and `B`, according to our `allowed` list. We want to know if we can build a pyramid to the top.

Given `bottom`, the base of the pyramid, and `allowed`, the allowed triples, return `true` if we can reach the apex, false otherwise.

---

## Examples

**Example 1:**
```
Input:  bottom = "BCD", allowed = ["BCC","CDE","CEA","FFF"]
Output: true
```

**Example 2:**
```
Input:  bottom = "AABA", allowed = ["AAA","AAB","ABA","ABB","BAC"]
Output: false
```

---

## Constraints

- `2 <= bottom.length <= 8`
- `0 <= allowed.length <= 200`
- `allowed[i].length == 3`
- The letters in all input strings are from the set `{'A', 'B', 'C', 'D', 'E', 'F', 'G'}`.
