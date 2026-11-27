# 819. Most Common Word — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/most-common-word/

---

## Solution: HashMap + Regex — O(n) time, O(n) space

**Idea:** Normalize paragraph to lowercase, split by non-alphabetic chars, count word frequencies excluding banned words.

**Algorithm:**
1. Put banned words in a set.
2. Split paragraph on non-letter characters, lowercase each word.
3. Count frequencies; return word with max frequency not in banned set.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — word count map |
