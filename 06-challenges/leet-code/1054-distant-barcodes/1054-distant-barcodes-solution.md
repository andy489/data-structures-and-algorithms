# 1054. Distant Barcodes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/distant-barcodes/

---

## Solution: Greedy with Max Heap — O(n log k) time, O(n) space

**Idea:** Always place the most frequent remaining barcode that differs from the last placed. Use a max heap by frequency.

**Algorithm:**
1. Count frequencies.
2. Max heap by frequency.
3. At each step: pop top. If it equals last placed, pop next-top, place it, re-push top. Else place top.
4. Push back used item if count > 0.

**Complexity:**

| | |
|---|---|
| Time | O(n log k) |
| Space | O(n) |
