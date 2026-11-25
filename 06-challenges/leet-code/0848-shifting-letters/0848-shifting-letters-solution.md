# 848. Shifting Letters — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shifting-letters/

---

## Solution: Suffix Sum — O(n) time, O(1) space

**Idea:** Each character `s[i]` is shifted by `shifts[i] + shifts[i+1] + ... + shifts[n-1]`. Compute suffix sums from right to left and apply each total shift.

**Algorithm:**
1. Traverse from right to left, accumulating a running sum of shifts.
2. For each character, apply `(char - 'a' + totalShift) % 26 + 'a'`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — in-place char array |
