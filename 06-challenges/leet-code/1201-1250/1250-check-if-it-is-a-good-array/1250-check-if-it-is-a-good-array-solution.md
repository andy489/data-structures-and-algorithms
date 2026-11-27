# 1250. Check If It Is a Good Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/check-if-it-is-a-good-array/

---

## Solution: GCD (Bezout's Identity) — O(n log max) time, O(1) space

**Idea:** By Bezout's identity, there exist integers a1,...,ak such that a1*n1+...+ak*nk=1 if and only if gcd(n1,...,nk)=1.

**Algorithm:**
1. Compute GCD of all elements.
2. Return true if GCD == 1.

**Complexity:**

| | |
|---|---|
| Time | O(n log max) |
| Space | O(1) |
