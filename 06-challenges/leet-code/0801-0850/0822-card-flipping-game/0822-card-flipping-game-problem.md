# 822. Card Flipping Game

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/card-flipping-game/

---

## Problem Statement

You have `n` cards. The `i`th card has a number `fronts[i]` written on the front and `backs[i]` on the back. We pick one card, and if the number `x` on the picked card's chosen face is not on the front of any card, then this number is good. Return the minimum possible good number, or 0 if no good number exists.

---

## Examples

**Example 1:**
```
Input:  fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
Output: 2
```

---

## Constraints

- `n == fronts.length == backs.length`
- `1 <= n <= 1000`
- `1 <= fronts[i], backs[i] <= 2000`
