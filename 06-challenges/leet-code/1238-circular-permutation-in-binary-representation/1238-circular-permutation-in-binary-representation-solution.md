# 1238. Circular Permutation in Binary Representation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/circular-permutation-in-binary-representation/

---

## Solution: Gray Code with XOR — O(2^n) time, O(2^n) space

**Idea:** Generate standard Gray code sequence (i XOR i>>1), then XOR each element with start to rotate.

**Algorithm:**
1. Generate Gray code: for i in 0..2^n-1: i ^ (i>>1).
2. XOR each with start to get the rotated sequence.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) |
| Space | O(2^n) |
