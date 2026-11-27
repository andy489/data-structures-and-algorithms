# 824. Goat Latin — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/goat-latin/

---

## Solution: String Manipulation — O(n²) time, O(n) space

**Idea:** Apply the transformation rules to each word, appending increasing number of 'a's.

**Algorithm:**
1. Split sentence into words.
2. For each word at index i (1-based): if vowel start, append "ma" + "a"*i; else rotate first char to end and append "ma" + "a"*i.
3. Join with spaces.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — building strings with trailing a's |
| Space | O(n) — output string |
