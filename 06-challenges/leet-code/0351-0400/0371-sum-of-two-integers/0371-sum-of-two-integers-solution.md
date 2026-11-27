# 371. Sum of Two Integers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-two-integers/

---

## Solution: Bit Manipulation — O(1) time, O(1) space

**Idea:** `a XOR b` gives the sum without carry; `(a AND b) << 1` gives the carries. Repeat until no carry.

**Algorithm:**
1. While `b != 0`: compute `carry = (a & b) << 1`, then `a = a ^ b`, then `b = carry`.
2. Return `a`.

**Complexity:**

| | |
|---|---|
| Time | O(1) — at most 32 iterations |
| Space | O(1) |
