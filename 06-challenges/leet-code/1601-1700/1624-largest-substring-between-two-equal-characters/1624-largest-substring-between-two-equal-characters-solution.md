# 1624. Largest Substring Between Two Equal Characters — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/largest-substring-between-two-equal-characters/

---

## Solution: First Occurrence Map — O(n) time, O(1) space

**Idea:** Store the first occurrence index of each character. For each subsequent occurrence of the same character, the substring length between them is `current_index - first_index - 1`. Track the maximum.

**Algorithm:**
1. Maintain a map `first` from character to its first seen index; initialize to -1 for all 26 letters.
2. For each character at index `i`:
   - If `first[c] == -1`, record `first[c] = i`.
   - Otherwise, update answer with `i - first[c] - 1`.
3. Return the answer (or -1 if no pair found).

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — 26-entry array |
