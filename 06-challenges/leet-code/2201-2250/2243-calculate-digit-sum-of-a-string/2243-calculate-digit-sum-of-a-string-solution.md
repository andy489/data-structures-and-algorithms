# 2243. Calculate Digit Sum of a String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/calculate-digit-sum-of-a-string/

---

## Solution: Simulation — O(n / k · n) time, O(n) space

**Idea:** Simulate each round directly: split the current string into chunks of size `k`, replace each chunk with the string representation of its digit sum, concatenate the results, and repeat until the length no longer exceeds `k`.

**Algorithm:**
1. While `s.length > k`:
   - Build a new string by iterating over chunks of size `k`.
   - For each chunk, sum its digit characters and append the sum (as a string) to the result.
   - Replace `s` with the new string.
2. Return `s`.

**Complexity:**

| | |
|---|---|
| Time | O((n/k) · n) — each round reduces length by a factor related to k; at most O(n/k) rounds, each O(n) |
| Space | O(n) — intermediate string per round |
