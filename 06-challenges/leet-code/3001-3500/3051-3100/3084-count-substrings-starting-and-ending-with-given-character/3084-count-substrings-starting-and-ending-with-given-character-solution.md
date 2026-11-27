# 3084. Count Substrings Starting And Ending With Given Character — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/

---

## Solution: Math (Combinatorics) — O(n) time, O(1) space

**Idea:** Count k = occurrences of c. Each pair of positions (including same position) forms a valid substring. Answer = k*(k+1)/2.

**Algorithm:**
1. Count k = number of c's in s.
2. Return k*(k+1)/2 (choose 2 positions with repetition).

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) |
| Space | O(1) — O(1) |
