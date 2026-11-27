# 1455. Check If A Word Occurs As A Prefix Of Any Word In A Sentence — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

---

## Solution: Linear Scan — O(n * m) time, O(1) space

**Idea:** Split sentence into words, check each word for the prefix.

**Algorithm:**
1. Split sentence. For each word (1-indexed): if word starts with searchWord, return index.
2. Return -1 if none found.

**Complexity:**

| | |
|---|---|
| Time | O(n * m) |
| Space | O(1) |
