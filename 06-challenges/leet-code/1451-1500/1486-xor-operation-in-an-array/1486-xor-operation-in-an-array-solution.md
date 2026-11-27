# 1486. Xor Operation In An Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/xor-operation-in-an-array/

---

## Solution: Linear XOR — O(n) time, O(1) space

**Idea:** Compute XOR of start, start+2, start+4, ..., start+2*(n-1).

**Algorithm:**
1. Initialize result = 0. For i in 0..n-1: result ^= start + 2*i. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
