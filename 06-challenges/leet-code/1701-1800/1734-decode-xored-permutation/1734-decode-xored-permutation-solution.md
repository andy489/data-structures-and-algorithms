# 1734. Decode XORed Permutation — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/decode-xored-permutation/

---

## Solution: XOR Total + Even-index Groups — O(n) time, O(n) space

**Idea:** Let `total = 1 XOR 2 XOR ... XOR n`. We need `perm[0]`. Notice `encoded[1] XOR encoded[3] XOR ...` = `perm[1] XOR perm[2] XOR perm[3] XOR perm[4] XOR ...` (all elements except `perm[0]`). So `perm[0] = total XOR (encoded[1] XOR encoded[3] XOR ...)`. Then reconstruct as in problem 1720.

**Algorithm:**
1. Compute `total = XOR of 1..n`.
2. Compute `rest = XOR of encoded[i]` for all odd indices `i`.
3. `perm[0] = total XOR rest`.
4. For `i` from 1 to `n-1`: `perm[i] = perm[i-1] XOR encoded[i-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(n) — output array |
