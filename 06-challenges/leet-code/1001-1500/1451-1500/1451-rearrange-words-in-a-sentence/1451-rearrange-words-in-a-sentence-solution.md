# 1451. Rearrange Words In A Sentence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rearrange-words-in-a-sentence/

---

## Solution: Stable Sort — O(n log n) time, O(n) space

**Idea:** Lowercase all, split, stable sort by length, capitalize first, join.

**Algorithm:**
1. Lowercase text, split to words.
2. Stable sort by len.
3. Capitalize first word, join with spaces.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
