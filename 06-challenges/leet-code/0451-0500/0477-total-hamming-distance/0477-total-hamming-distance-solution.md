# 477. Total Hamming Distance — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/total-hamming-distance/

---

## Solution: Bit Counting — O(32 · N) time, O(1) space

**Idea:** For each bit position, count how many numbers have a 1 there (`ones`) and how many have a 0 (`zeros = N - ones`). Each such pair contributes 1 to Hamming distance, so contribution = `ones * zeros`.

**Algorithm:**
1. For each of 32 bit positions:
   - Count numbers with that bit set.
   - Add `count * (n - count)` to total.

**Complexity:**

| | |
|---|---|
| Time | O(32 · N) = O(N) |
| Space | O(1) |
