# 1979. Find Greatest Common Divisor of Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-greatest-common-divisor-of-array/

---

## Solution: Min/Max + GCD — O(n) time, O(1) space

**Idea:** Find the minimum and maximum of the array, then return their GCD using the Euclidean algorithm.

**Algorithm:**
1. Find `mn = min(nums)` and `mx = max(nums)`.
2. Return `gcd(mn, mx)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
