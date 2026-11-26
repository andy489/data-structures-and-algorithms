# 1442. Count Triplets That Can Form Two Arrays Of Equal Xor — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/

---

## Solution: Prefix XOR — O(n^2) time, O(n) space

**Idea:** If xor(i..j-1) == xor(j..k), then xor(i..k) == 0. For each pair (i,k) where prefix_xor[i] == prefix_xor[k+1], all k-i choices of j are valid.

**Algorithm:**
1. Compute prefix XOR.
2. For each i, k: if prefix[i] == prefix[k+1], add (k-i) to answer.
3. Return answer.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
