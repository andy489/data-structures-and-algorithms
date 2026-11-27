# 1754. Largest Merge of Two Strings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-merge-of-two-strings/

---

## Solution: Greedy Suffix Comparison — O((m+n)·min(m,n)) time, O(m+n) space

**Idea:** Greedily pick the lexicographically larger remaining suffix. At each step, compare the remaining suffix of `word1` from index `i` with the remaining suffix of `word2` from index `j`. If `word1[i:]` > `word2[j:]` take from `word1`; if `word2[j:]` > take from `word2`; if equal, take from either (take `word1` to stay consistent). This is correct because taking the lexicographically larger suffix ensures the best future choices.

**Algorithm:**
1. Use two pointers `i`, `j`.
2. While both are valid, compare suffixes and append the leading char from the larger.
3. Append the remaining non-exhausted string.

**Complexity:**

| | |
|---|---|
| Time | O((m+n)·min(m,n)) — suffix comparison at each step |
| Space | O(m+n) — output string |
