# 365. Water and Jug Problem — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/water-and-jug-problem/

---

## Solution: Bézout's Identity (GCD) — O(log(min(x,y))) time, O(1) space

**Idea:** By Bézout's theorem, any amount achievable is a multiple of `gcd(x, y)`. The target must be: (1) a multiple of `gcd(x, y)`, and (2) at most `x + y`.

**Algorithm:**
1. If `target > x + y`, return false.
2. If `target % gcd(x, y) == 0`, return true; else false.

**Complexity:**

| | |
|---|---|
| Time | O(log(min(x, y))) — Euclidean GCD |
| Space | O(1) |
