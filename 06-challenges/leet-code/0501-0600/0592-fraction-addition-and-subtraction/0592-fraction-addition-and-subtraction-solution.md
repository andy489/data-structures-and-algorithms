# 592. Fraction Addition and Subtraction — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/fraction-addition-and-subtraction/

---

## Solution: Parse and Accumulate — O(k) time, O(1) space

**Idea:** Parse fractions one by one using a regex or manual scan. Keep a running numerator and denominator. For each new fraction `a/b`, compute: `num = num*b + a*den`, `den = den*b`, then reduce by GCD.

**Algorithm:**
1. Use regex `[+\-]?\d+/\d+` to split tokens.
2. For each fraction, add to accumulator: `numAcc = numAcc * denom + num * denomAcc`, `denomAcc *= denom`.
3. Reduce by `gcd(|numAcc|, denomAcc)`.
4. Return `numAcc + "/" + denomAcc`.

**Complexity:**

| | |
|---|---|
| Time | O(k) where k = number of fractions |
| Space | O(1) |
