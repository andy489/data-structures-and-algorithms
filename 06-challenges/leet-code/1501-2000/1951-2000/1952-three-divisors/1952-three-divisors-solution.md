# 1952. Three Divisors — Solution

## Approach

A number has exactly three divisors if and only if it is the square of a prime. This is because if n = p^2 where p is prime, the only divisors are 1, p, and p^2.

**Algorithm:**
1. Count divisors by iterating from 1 to n.
2. Return true if exactly 3 divisors found.

**Complexity:** O(n) time, O(1) space.
