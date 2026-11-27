# 2103. Rings and Rods

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/rings-and-rods/

---

## Problem Statement

There are `n` rings and each ring is either red, green, or blue. The rings are distributed across ten rods labeled from `0` to `9`.

You are given a string `rings` of length `2n` that describes the `n` rings that are placed onto the rods. Every two characters in `rings` forms a color-position pair that is used to describe each ring where:

- The first character of the ith pair denotes the ith ring's color (`'R'`, `'G'`, `'B'`).
- The second character of the ith pair denotes the rod that the ith ring is placed on (`'0'` to `'9'`).

Return the number of rods that have **all three colors** of rings on them.

---

## Examples

**Example 1:**
```
Input:  rings = "B0B6G0R6R0R6G9"
Output: 1
Explanation:
- Rod 0 holds red, green, and blue rings.
- Rod 6 holds only red and blue.
- Rod 9 holds only green.
Thus, the number of rods with all three colors is 1.
```

**Example 2:**
```
Input:  rings = "B0R0G0R9R0B0G0"
Output: 1
Explanation:
- Rod 0 holds red, green, and blue rings.
- Rod 9 holds only red.
Thus, the number of rods with all three colors is 1.
```

**Example 3:**
```
Input:  rings = "G4"
Output: 0
Explanation:
Only one ring is given. Thus, no rods have all three colors.
```

---

## Constraints

- `rings.length == 2 * n`
- `1 <= n <= 100`
- `rings[i]` where `i` is even is either `'R'`, `'G'`, or `'B'` (0-indexed).
- `rings[i]` where `i` is odd is a digit from `'0'` to `'9'` (0-indexed).
