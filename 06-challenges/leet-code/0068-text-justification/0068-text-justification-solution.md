# 68. Text Justification — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/text-justification/

---

## Solution: Greedy Line Packing — O(n·W) time, O(n·W) space

**Idea:** Greedily group words into lines so each line holds as many words as possible. For each non-last line with more than one word, distribute spaces evenly across the gaps, giving leftmost gaps one extra space when division is uneven. The last line is left-justified with single spaces between words and trailing spaces to fill `maxWidth`.

**Algorithm:**
1. Scan words greedily: accumulate words until adding the next would exceed `maxWidth` (counting one space between each word).
2. For each line:
   - Count `gaps = (number of words) - 1`.
   - If last line or single word: join with one space and right-pad to `maxWidth`.
   - Otherwise: `totalSpaces = maxWidth - sum(word lengths)`. `spacePerGap = totalSpaces / gaps`, `extra = totalSpaces % gaps`. First `extra` gaps get `spacePerGap + 1` spaces; the rest get `spacePerGap`.
3. Append each built line to the result.

**Complexity:**

| | |
|---|---|
| Time | O(n·W) — n words, W = maxWidth; building each line is O(W) |
| Space | O(n·W) — result list holds all lines |
