# 528. Random Pick with Weight

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/random-pick-with-weight/

---

## Problem Statement

You are given a **0-indexed** array of positive integers `w` where `w[i]` describes the **weight** of the `i`th index.

Implement the function `pickIndex()`, which **randomly** picks an index in the range `[0, w.length - 1]` (**inclusive**) and returns it. The probability of picking an index `i` is `w[i] / sum(w)`.

---

## Examples

**Example 1:**
```
Input:  w = [1], pickIndex() → 0
```

**Example 2:**
```
Input:  w = [1,3], pickIndex() calls →
        0 (probability 0.25), 1 (probability 0.75)
```

---

## Constraints

- `1 <= w.length <= 10^4`
- `1 <= w[i] <= 10^5`
- `pickIndex` will be called at most `10^4` times.
