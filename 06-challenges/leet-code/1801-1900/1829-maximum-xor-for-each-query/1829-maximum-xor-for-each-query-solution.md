# 1829. Maximum XOR for Each Query — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-xor-for-each-query/

---

## Solution: Prefix XOR — O(n) time, O(n) space

**Idea:** To maximize `xorAll XOR k` where `k < 2^maximumBit`, the optimal `k` is `xorAll XOR mask` where `mask = 2^maximumBit - 1` (all 1s in the relevant bits). This flips all bits of `xorAll` in the allowed range, giving the maximum value. Process queries from right to left (last element removed first), maintaining a running XOR.

**Algorithm:**
1. Compute `xorAll` = XOR of all elements.
2. Set `mask = (1 << maximumBit) - 1`.
3. For `i` from `n-1` down to `0`:
   - Append `xorAll ^ mask` to answer.
   - Remove `nums[i]` from XOR: `xorAll ^= nums[i]`.
4. Return answer array.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear passes (one to compute xorAll, one for queries) |
| Space | O(n) — output answer array |
