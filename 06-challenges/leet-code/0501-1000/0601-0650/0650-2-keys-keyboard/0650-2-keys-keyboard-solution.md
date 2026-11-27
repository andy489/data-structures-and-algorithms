# 650. 2 Keys Keyboard — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/2-keys-keyboard/

---

## Solution: Prime Factorization — O(√n) time, O(1) space

**Idea:** The minimum steps equals the sum of prime factors of n. For each prime factor p that divides n, it takes p steps (1 copy + p-1 pastes). So summing prime factors gives total steps.

**Algorithm:**
1. For i from 2 to √n: while n divisible by i, add i to steps, divide n by i.
2. If n > 1 at end, it's a prime factor; add n.

**Complexity:**

| | |
|---|---|
| Time | O(√n) |
| Space | O(1) |
