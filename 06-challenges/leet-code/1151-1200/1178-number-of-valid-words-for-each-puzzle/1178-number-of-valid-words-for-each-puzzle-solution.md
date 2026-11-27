# 1178. Number of Valid Words for Each Puzzle — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/

---

## Solution: Bitmask + Subset Enumeration — O(w × L + p × 2^7) time, O(w) space

**Idea:** Represent each word as a 26-bit bitmask of its unique letters. Store bitmask frequencies in a hash map. For each puzzle, enumerate all subsets of its 7-letter bitmask that include the first letter — each subset is a candidate word bitmask. Sum counts from the frequency map.

Since each puzzle has exactly 7 letters, there are at most `2^7 = 128` subsets per puzzle, making this very efficient.

**Algorithm:**
1. Build `freq` map: word_mask → count of words with that mask.
2. For each puzzle: compute `puzzleMask` and `firstBit = 1 << (puzzle[0] - 'a')`.
3. Enumerate all subsets of `puzzleMask` that include `firstBit` using subset enumeration: `sub = puzzleMask; sub > 0; sub = (sub - 1) & puzzleMask`.
4. For each such subset, add `freq.getOrDefault(sub, 0)` to the answer.

**Complexity:**

| | |
|---|---|
| Time | O(w × L + p × 2^7) — w words of avg length L, p puzzles with 128 subsets each |
| Space | O(w) — frequency map of word bitmasks |
