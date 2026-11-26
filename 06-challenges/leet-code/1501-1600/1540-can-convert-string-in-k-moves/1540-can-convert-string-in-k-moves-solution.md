# 1540. Can Convert String in K Moves — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/can-convert-string-in-k-moves/

---

## Solution: Shift Frequency Count — O(n) time, O(1) space

**Idea:** Each character position with shift `d` (1..25) needs a unique move number. The first occurrence of shift `d` can use move `d`, the second needs move `d + 26`, the third needs `d + 52`, etc. We track how many times each shift value appears and check if the required move number exceeds k.

**Algorithm:**
1. For each pair (s[i], t[i]), compute `diff = (t[i] - s[i] + 26) % 26`.
2. If diff != 0, increment `count[diff]`.
3. The minimum move needed for the `count[diff]`-th occurrence is `count[diff] * 26 - 26 + diff`.
4. If that exceeds k, return false.
5. If all checks pass, return true.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — fixed array of 26 |
