# 2085. Count Common Words With One Occurrence — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-common-words-with-one-occurrence/

---

## Solution: Frequency Count — O(n + m) time, O(n + m) space

**Idea:** Count frequencies in both arrays. Count words appearing exactly once in each.

**Algorithm:**
1. Build frequency maps for both arrays.
2. Count words with freq == 1 in both.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(n + m) |
