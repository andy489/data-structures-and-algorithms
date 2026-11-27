# 3370. Smallest Number With All Set Bits — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/smallest-number-with-all-set-bits/

---

## Solution: Bit Length Mask — O(log n) time, O(1) space

**Idea:** A number with all set bits in k bits is `(1 << k) - 1` (e.g. k=3 → 7, k=4 → 15). The smallest such number >= n is obtained by finding the bit length of n (number of bits needed to represent n), then returning `(1 << bitLen) - 1`. This gives the all-ones mask of the same bit-width as n, which is the smallest all-set-bits number >= n.

**Algorithm:**
1. Find `bitLen = floor(log2(n)) + 1`, i.e., the number of bits in `n`.
2. Return `(1 << bitLen) - 1`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — bit length computation |
| Space | O(1) — no extra space |
