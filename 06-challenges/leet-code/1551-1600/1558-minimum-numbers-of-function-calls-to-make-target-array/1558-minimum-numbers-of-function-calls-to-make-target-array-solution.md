# 1558. Minimum Numbers of Function Calls to Make Target Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/

---

## Solution: Bit Analysis — O(n * max_bits) time, O(1) space

**Idea:** Think in reverse: starting from `nums`, we halve as many times as possible (the global doublings), and add 1 for each set bit in each number. The number of `+1` operations equals the total number of set bits across all numbers. The number of `*2` operations equals the maximum bit-length minus 1 (we share doublings globally).

**Algorithm:**
1. Count total set bits across all numbers — that's the number of add-1 operations.
2. Find the maximum bit-length across all numbers — that minus 1 is the number of double operations.
3. Return sum.

**Complexity:**

| | |
|---|---|
| Time | O(n * B) — where B is the max number of bits (~30) |
| Space | O(1) — only counters |
