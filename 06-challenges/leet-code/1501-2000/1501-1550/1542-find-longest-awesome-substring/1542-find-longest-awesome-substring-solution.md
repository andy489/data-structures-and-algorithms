# 1542. Find Longest Awesome Substring — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-longest-awesome-substring/

---

## Solution: Bitmask Prefix XOR — O(n) time, O(1) space

**Idea:** A substring can form a palindrome if at most one digit has an odd frequency. Use a 10-bit prefix XOR mask where bit d is 1 if digit d has odd parity up to index i. A substring [j+1..i] is awesome if its XOR mask is 0 (all even) or has exactly one bit set (one odd). So we look for prior indices where the mask equals current mask (XOR = 0) or differs by exactly one bit.

**Algorithm:**
1. Maintain `mask` = running XOR of digit bits.
2. Store `firstSeen[mask]` = earliest index where this mask appeared (-1 for index -1 meaning empty prefix).
3. At each index i:
   - If `firstSeen[mask]` exists, update best = max(best, i - firstSeen[mask]).
   - Otherwise record `firstSeen[mask] = i`.
   - Try all 10 single-bit flips; if `firstSeen[flipped]` exists, update best.

**Complexity:**

| | |
|---|---|
| Time | O(n) — 10 constant work per character |
| Space | O(1) — fixed array of 2^10 = 1024 |
