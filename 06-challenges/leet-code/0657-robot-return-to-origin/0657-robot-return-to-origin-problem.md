# 657. Robot Return to Origin

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/robot-return-to-origin/

---

## Problem Statement

There is a robot starting at the position `(0, 0)`, the origin, on a 2D plane. Given a sequence of its moves, judge if this robot **ends up at** `(0, 0)` after it completes its moves.

You are given a string `moves` that represents the move sequence of the robot where `moves[i]` represents its `i`th move. Valid moves are `'R'` (right), `'L'` (left), `'U'` (up), and `'D'` (down).

Return `true` if the robot returns to the origin after it finishes all of its moves, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  moves = "UD"
Output: true
```

**Example 2:**
```
Input:  moves = "LL"
Output: false
```

---

## Constraints

- `1 <= moves.length <= 2 * 10⁴`
- `moves` only contains the characters `'U'`, `'D'`, `'L'`, and `'R'`.
