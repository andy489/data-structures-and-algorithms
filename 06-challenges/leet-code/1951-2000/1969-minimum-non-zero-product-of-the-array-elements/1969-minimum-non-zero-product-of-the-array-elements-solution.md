# 1969. Minimum Non-Zero Product of the Array Elements — Solution

## Approach

Key insight: The number 2^p - 1 (all 1s in binary) must remain. We can pair up all other numbers: pair (1, 2^p - 2), (3, 2^p - 4), etc., making each pair become (1, 2^p - 2) repeated.

There are 2^(p-1) - 1 such pairs and one instance of 2^p - 1. So:
- Answer = (2^p - 1) * (2^p - 2)^(2^(p-1) - 1) mod (10^9 + 7)

Use fast modular exponentiation.

**Complexity:** O(p) time, O(1) space.
