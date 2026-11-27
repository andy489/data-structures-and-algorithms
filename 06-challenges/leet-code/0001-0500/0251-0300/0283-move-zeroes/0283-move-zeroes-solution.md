# 283. Move Zeroes — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/move-zeroes/

---

## Solution: Two-Pointer (Write Pointer) — O(n) time, O(1) space

**Idea:** Maintain a `write` pointer. For each non-zero element, write it to position `write` and advance. After processing all elements, fill from `write` to end with zeros.

**Algorithm:**
1. `write = 0`.
2. For each `num` in `nums`: if `num != 0`, set `nums[write++] = num`.
3. Fill `nums[write..n-1]` with `0`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — in-place |
