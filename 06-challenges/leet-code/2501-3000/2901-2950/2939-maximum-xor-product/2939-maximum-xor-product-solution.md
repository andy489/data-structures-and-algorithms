# 2939. Maximum Xor Product — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-xor-product/

---

## Solution: Greedy Bit-by-Bit — O(n) time, O(1) space

**Idea:** For each bit position from the most significant down to 0 (within the n-bit range), we want to maximize the product `(a XOR x) * (b XOR x)`. The product is maximized when both factors are as large as possible and as equal as possible.

For each bit i (0 <= i < n):
- If both a and b have the same bit (both 0 or both 1): set that bit in x to 1 to maximize both factors (flipping both bits to 1).
- If a and b have different bits: set that bit in x to give the larger factor the smaller boost — i.e., set the bit of the currently smaller accumulated value to 1 to balance the two factors.

**Algorithm:**
1. Walk bits from n-1 down to 0.
2. Let bitA = (a >> i) & 1, bitB = (b >> i) & 1.
3. If bitA == bitB: set x bit i = 1 (both become 1 after XOR).
4. Else: give the 1-bit to whichever of a, b is currently smaller to balance.
5. Apply modulo at the end for the final product.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
