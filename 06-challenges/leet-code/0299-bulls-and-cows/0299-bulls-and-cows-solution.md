# 299. Bulls and Cows — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bulls-and-cows/

---

## Solution: Single Pass with Frequency Count — O(n) time, O(1) space

**Idea:** Count bulls in one pass. For non-bull positions, track digit frequencies from both secret and guess. A cow is a digit that appears in both non-bull portions — counted by the minimum frequency of each digit across the two sides.

**Algorithm:**
1. Count `bulls` (exact position match).
2. For non-matching positions, increment `secretFreq[digit]` and `guessFreq[digit]`.
3. `cows = sum of min(secretFreq[d], guessFreq[d])` for all digits `d`.

Alternatively, a single array: for each unmatched position, increment count for secret digit and decrement for guess digit. When count for guess digit was positive, it means we've seen it in secret before → cow.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — fixed 10-digit frequency array |
