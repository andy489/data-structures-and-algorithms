# 754. Reach a Number

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reach-a-number/

---

## Problem Statement

You are standing at position `0` on an infinite number line. There is a destination at position `target`.

You can make some number of moves `numMoves` so that:
- On move `i`, you can walk in either direction, taking `i` steps.

Return the **minimum** number of moves required (i.e. the minimum `numMoves`) to reach the destination.

---

## Examples

**Example 1:**
```
Input:  target = 2
Output: 3
Explanation: Move 1: +1, Move 2: +2, Move 3: -1 → position: 2
```

**Example 2:**
```
Input:  target = 3
Output: 2
```

---

## Constraints

- `-10^9 <= target <= 10^9`
- The answer will fit in a 32-bit integer.
