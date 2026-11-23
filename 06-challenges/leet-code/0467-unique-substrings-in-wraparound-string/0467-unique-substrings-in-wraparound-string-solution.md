# 467. Unique Substrings in Wraparound String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/unique-substrings-in-wraparound-string/

---

## Solution: DP — O(n) time, O(1) space

**Idea:** A substring of `p` is in the wraparound string iff it is a contiguous run in the alphabet (possibly wrapping z→a). For each character `c`, track the longest such run ending at `c` seen so far. The count of valid unique substrings ending at `c` equals that longest run length. Sum over all 26 characters.

**Algorithm:**
1. Maintain `curLen` = length of current valid run. For each char at index `i`: if it extends the previous char (or is the start), increment `curLen`; else reset to 1.
2. Update `maxLen[c] = max(maxLen[c], curLen)` for current char `c`.
3. Answer = sum of `maxLen`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — fixed 26-entry array |
