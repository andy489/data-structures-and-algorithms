# 837. New 21 Game

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/new-21-game/

---

## Problem Statement

Alice plays the following game: she starts with `0` points and draws numbers while she has fewer than `k` points. On each draw she gains 1 to `maxPts` points (uniform random). Alice stops drawing when she has ≥ k points. Return the probability that she has ≤ n points when she stops.

---

## Examples

**Example 1:**
```
Input:  n = 10, k = 1, maxPts = 10
Output: 1.00000
```

**Example 2:**
```
Input:  n = 6, k = 2, maxPts = 2
Output: 0.60000
```

---

## Constraints

- `0 <= k <= n <= 10^4`
- `1 <= maxPts <= 10^4`
