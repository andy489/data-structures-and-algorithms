# 1611. Minimum One Bit Operations to Make Integers Zero

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/

---

## Problem Statement

Given an integer `n`, you must transform it into `0` using the following operations any number of times:

- Change the rightmost (`0`th) bit in the binary representation of `n`.
- Change the `i`th bit in the binary representation of `n` if the `(i-1)`th bit is set to `1` and the `(i-2)`th through `0`th bits are set to `0`.

Return the **minimum number of operations** to transform `n` into `0`.

---

## Examples

**Example 1:**
```
Input: n = 6
Output: 4
Explanation: 6 → 7 → 5 → 4 → 0 (binary: 110 → 111 → 101 → 100 → 000)
```

**Example 2:**
```
Input: n = 0
Output: 0
```

---

## Constraints

- `0 <= n <= 10^9`
