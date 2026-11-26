# 2014. Longest Subsequence Repeated k Times — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/longest-subsequence-repeated-k-times/

---

## Solution: BFS/Greedy on Candidates — O(n * m^2 / k) time, O(m!) space

**Idea:** Only chars with freq >= k can appear in answer. BFS over candidate subsequences in decreasing length.

**Algorithm:**
1. Collect chars with freq >= k.
2. BFS: start from empty, extend one char at a time.
3. For each candidate check if it repeated k times is subsequence of s.
4. Return longest found (lexicographically greatest for ties).

**Complexity:**

| | |
|---|---|
| Time | O(n * m^2 / k) |
| Space | O(m!) |
