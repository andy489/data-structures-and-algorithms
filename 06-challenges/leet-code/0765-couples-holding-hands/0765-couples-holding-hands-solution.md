# 765. Couples Holding Hands — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/couples-holding-hands/

---

## Solution: Greedy Swap — O(n²) time, O(n) space

**Idea:** For each even index `i`, the person at `i` needs their partner `i^1` (XOR with 1 gives partner: 0↔1, 2↔3, etc.) next to them. If `row[i+1]` is not the partner, find the partner and swap them into position `i+1`. Count swaps.

**Algorithm:**
1. For i = 0, 2, 4, ...:
   - `partner = row[i] ^ 1`.
   - If `row[i+1] != partner`, find `partner`'s position and swap it to `i+1`. Count++.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — scan for partner each time |
| Space | O(1) — in-place swaps |
