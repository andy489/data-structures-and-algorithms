# 319. Bulb Switcher — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bulb-switcher/

---

## Solution: Math (Perfect Squares) — O(1) time, O(1) space

**Idea:** Bulb `i` is toggled once for each divisor of `i`. It ends ON iff it has an odd number of divisors. Only perfect squares have an odd number of divisors (since divisors pair up except when `d*d = i`). So the answer is `floor(sqrt(n))`.

**Algorithm:**
1. Return `(int) Math.sqrt(n)`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
