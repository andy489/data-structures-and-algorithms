# 2042. Check If Numbers Are Ascending in a Sentence — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/

---

## Solution: Tokenize and Compare — O(n) time, O(1) space

**Idea:** Split on spaces. Extract numbers, check strictly increasing.

**Algorithm:**
1. Split `s` by spaces.
2. For each token that is numeric, compare with previous number.
3. Return false if not strictly increasing.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
