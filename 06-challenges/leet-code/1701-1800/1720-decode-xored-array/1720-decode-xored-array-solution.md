# 1720. Decode XORed Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/decode-xored-array/

---

## Solution: XOR Prefix Reconstruction — O(n) time, O(n) space

**Idea:** Since `encoded[i] = arr[i] XOR arr[i+1]`, we recover `arr[i+1] = encoded[i] XOR arr[i]`. Starting from `first = arr[0]`, reconstruct each subsequent element in one pass.

**Algorithm:**
1. Initialize `arr[0] = first`.
2. For each index `i` from `0` to `encoded.length - 1`: set `arr[i+1] = encoded[i] XOR arr[i]`.
3. Return `arr`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — output array |
