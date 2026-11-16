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

**Idea:** `n & (-n)` isolates the lowest set bit. If that equals `n` itself, then `n` has exactly one bit set — i.e. it is a power of two.

**Algorithm:**
1. Return `n > 0 && (n & (-n)) == n`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — single bitwise operation |
| Space | O(1) |

---

## Solution 3: Integer Logarithm — O(1) time, O(1) space

**Idea:** `Integer.MAX_VALUE`'s largest power-of-two factor is `2^30 = 1073741824`. Any power of two divides this constant evenly; no non-power-of-two does.

**Algorithm:**
1. Return `n > 0 && (1073741824 % n == 0)`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — single modulo operation |
| Space | O(1) |
