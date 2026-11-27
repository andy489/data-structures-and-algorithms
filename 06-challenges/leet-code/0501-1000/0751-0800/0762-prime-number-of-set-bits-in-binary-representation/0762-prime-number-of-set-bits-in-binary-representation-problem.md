# 762. Prime Number of Set Bits in Binary Representation

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

---

## Problem Statement

Given two integers `left` and `right`, return the **count** of numbers in the **inclusive** range `[left, right]` having a **prime number of set bits** in their binary representation.

Recall that the **number of set bits** an integer has is the number of `1`'s present when written in binary.

---

## Examples

**Example 1:**
```
Input:  left = 6, right = 10
Output: 4
Explanation: 6 → 110 (2 bits), 7 → 111 (3 bits), 8 → 1000 (1 bit), 9 → 1001 (2 bits), 10 → 1010 (2 bits)
Primes: 2, 3, 2, 2 → 4 numbers
```

---

## Constraints

- `1 <= left <= right <= 10^6`
- `0 <= right - left <= 10^4`
