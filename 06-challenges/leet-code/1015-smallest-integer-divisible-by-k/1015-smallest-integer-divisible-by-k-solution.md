# 1015. Smallest Integer Divisible by K — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-integer-divisible-by-k/

---

## Solution: Modular Arithmetic — O(k) time, O(k) space

**Idea:** If k is divisible by 2 or 5, no repunit can divide k (repunits are odd and not multiples of 5). Otherwise, track remainder mod k. By pigeonhole, if we see a repeated remainder in k steps, there's no solution; if remainder becomes 0, we found it.

**Algorithm:**
1. If k % 2 == 0 or k % 5 == 0, return -1.
2. rem = 0; for length 1..k: rem = (rem * 10 + 1) % k; if rem == 0 return length.
3. Return -1.

**Complexity:**

| | |
|---|---|
| Time | O(k) |
| Space | O(1) |
