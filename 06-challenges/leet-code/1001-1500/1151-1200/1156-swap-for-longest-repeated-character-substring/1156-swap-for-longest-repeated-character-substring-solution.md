# 1156. Swap For Longest Repeated Character Substring — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/swap-for-longest-repeated-character-substring/

---

## Solution: Sliding Window / Run-Length Groups — O(n) time, O(1) space

**Idea:** Compress the string into runs (character, length). For each pair of same-character runs separated by exactly one character of a different run of length 1, the swap can bridge them. The combined length is `left_run + right_run + 1`, but capped at `total_count[char]` (we need a character to swap in from elsewhere). Also handle the trivial case of a single run with a spare character.

**Algorithm:**
1. Build a run-length encoding: list of `(char, length)` pairs.
2. Count total occurrences of each character.
3. For each run `i`, compute `base = runs[i].len`.
   - If the next run after a single-char gap has the same character: `merged = runs[i].len + runs[i+2].len + 1`, then `min(merged, count[char])`.
   - Also try `base + 1` if `count[char] > base` (a spare exists somewhere).
4. Track the maximum.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass for RLE, single pass over runs |
| Space | O(1) — at most 26 distinct characters in the run array (bounded) |
