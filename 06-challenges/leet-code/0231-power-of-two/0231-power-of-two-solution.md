# 231. Power of Two — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/power-of-two/

---

## Solution 1: Bit Trick — O(1) time, O(1) space

**Idea:** A power of two has exactly one bit set in its binary representation. Subtracting 1 flips that bit and sets all lower bits. Therefore `n & (n - 1) == 0` iff `n` is a power of two. Guard against `n <= 0` since negatives and zero are never powers of two.

**Algorithm:**
1. Return `n > 0 && (n & (n - 1)) == 0`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — single bitwise operation |
| Space | O(1) |

---

## Solution 2: Lowest Set Bit — O(1) time, O(1) space

**Idea:** In two's complement, `-n` is computed by flipping all bits of `n` and adding 1. Adding 1 to a string of trailing 1s carries through them all, so the lowest set bit of `n` is preserved while every bit above it is flipped and every bit below it becomes 0. ANDing `n` with `-n` therefore cancels all the differing upper bits and leaves only the shared lowest set bit.

```
n      =  0000 1100
-n     =  1111 0100   (flip all bits, then +1 carries through the trailing 1s)
n & -n =  0000 0100   ← only the lowest set bit survives
```

If `n` is a power of two it has exactly one bit set, so `n & (-n) == n`. If it has more than one bit set, the isolated lowest bit is strictly less than `n`.

**Algorithm:**
1. Return `n > 0 && (n & (-n)) == n`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — single bitwise operation |
| Space | O(1) |

---

## Solution 3: Integer Logarithm — O(1) time, O(1) space

**Idea:** `Integer.MAX_VALUE`'s largest power-of-two factor is `2^30 = 1 << 30`. Any power of two divides this constant evenly; no non-power-of-two does.

**Algorithm:**
1. Return `n > 0 && ((1 << 30) % n == 0)`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — single modulo operation |
| Space | O(1) |

---

## Solution 4: Built-in Popcount — O(1) time, O(1) space

**Idea:** A power of two has exactly one bit set. Use the language's built-in popcount (population count) to count set bits and check it equals 1.

**Algorithm:**
1. Return `n > 0 && bitCount(n) == 1`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — hardware-accelerated popcount instruction on modern CPUs |
| Space | O(1) |
