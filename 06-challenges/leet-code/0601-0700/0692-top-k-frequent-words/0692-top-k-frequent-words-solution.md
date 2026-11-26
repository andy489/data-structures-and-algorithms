# 692. Top K Frequent Words — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/top-k-frequent-words/

---

## Solution: HashMap + Sort — O(n log n) time, O(n) space

**Idea:** Count frequencies, sort by (-freq, word) to get highest freq first and lexicographically smallest on tie.

**Algorithm:**
1. Count word frequencies.
2. Sort unique words by (-count, word).
3. Return first k.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
