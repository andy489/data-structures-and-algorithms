# 1835. Find XOR Sum of All Pairs Bitwise AND — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/

---

## Solution: Bitwise Identity — O(n + m) time, O(1) space

**Idea:** Use the distributive law of XOR over AND:

```
XOR of all (arr1[i] AND arr2[j])
= (XOR of all arr1[i]) AND (XOR of all arr2[j])
```

This identity holds because for each bit position independently: a bit is set in the XOR-sum of products only when an odd number of `arr1[i] AND arr2[j]` have that bit set. This happens exactly when both the XOR of arr1 and the XOR of arr2 have that bit set.

**Algorithm:**
1. Compute `xor1 = XOR of all elements in arr1`.
2. Compute `xor2 = XOR of all elements in arr2`.
3. Return `xor1 AND xor2`.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — two linear passes |
| Space | O(1) — no extra storage |
