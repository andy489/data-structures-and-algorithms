# 372. Super Pow — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/super-pow/

---

## Solution: Modular Exponentiation — O(n) time, O(1) space

**Idea:** Use the identity `a^[d1,d2,...,dn] = (a^[d1,...,dn-1])^10 * a^dn mod 1337`. Process digits from left to right.

**Algorithm:**
1. Start with `result = 1`.
2. For each digit `d` in `b`: `result = powMod(result, 10) * powMod(a, d) mod 1337`.
3. `powMod(x, k)` computes `x^k mod 1337` using fast exponentiation.

**Complexity:**

| | |
|---|---|
| Time | O(n) — n digits, each with O(log 10) = O(1) powMod |
| Space | O(1) |
