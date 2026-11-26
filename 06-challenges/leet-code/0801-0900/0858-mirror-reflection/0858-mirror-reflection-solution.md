# 858. Mirror Reflection — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/mirror-reflection/

---

## Solution: Math (LCM) — O(log(p)) time, O(1) space

**Idea:** The ray travels lcm(p,q) vertical distance and lcm(p,q)/q bounces. It hits the right wall if lcm(p,q)/p is odd; hits the left (starting) wall if even. Among right wall hits, receptor 0 is at y=0 (bottom), receptor 2 is at y=p (top). Receptor 1 is on the left wall at y=p.

**Algorithm:**
1. Compute m = lcm(p, q) / q (number of times ray hits a wall).
2. If m is even: hits left wall (receptor 1 at top). But start is bottom-left corner, so must be receptor 1.
3. If m is odd: hits right wall. If lcm/p is even, receptor 0; if odd, receptor 2.

Simplified: let m = p/gcd(p,q), n = q/gcd(p,q). If m is even → receptor 1 (left wall top). Else if n is odd → receptor 1. Else if n is even → receptor 0.

Actually: if (m odd, n odd) → receptor 1; if (m odd, n even) → receptor 0; if (m even, _) → receptor 2.

**Complexity:**

| | |
|---|---|
| Time | O(log p) — GCD |
| Space | O(1) |
