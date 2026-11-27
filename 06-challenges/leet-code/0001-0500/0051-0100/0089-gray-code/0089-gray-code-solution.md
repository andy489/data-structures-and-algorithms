# 89. Gray Code — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/gray-code/

---

## Solution: Bit Formula — O(2^n) time, O(1) space

**Idea:** The `i`-th value in the standard Gray code sequence is `i XOR (i >> 1)`. This works because flipping from index `i-1` to `i` always changes exactly one bit in the XOR result.

**Algorithm:**
1. For `i` from `0` to `2^n - 1`, compute `i ^ (i >> 1)` and add to the result.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) — one pass over all 2^n indices |
| Space | O(1) — no extra storage beyond output |

---

## Solution 2: Recursive Reflection — O(2^n) time, O(2^n) space

**Idea:** Build the sequence recursively. The 1-bit sequence is `[0, 1]`. For each additional bit, take the previous sequence, keep it as-is (0 prepended), then append it in reverse with the new bit set to 1. Adjacent values across the mirror boundary differ by exactly one bit (the new bit).

**Algorithm:**
1. Start with `code = [0, 1]`.
2. For `bit` from `1` to `n-1`:
   - For each value in `code` reversed, add `(1 << bit) | value` to `code`.
3. Return `code`.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) — doubles each iteration |
| Space | O(2^n) — the reflected list stored during construction |
