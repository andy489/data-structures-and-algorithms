# 3016. Minimum Number of Pushes to Type Word II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/

---

## Solution: Greedy (Sort by Frequency) — O(n) time, O(1) space

**Idea:** Assign the most frequent letters to position 1, next most frequent to position 2, etc. Sort frequencies descending. Letter ranked i (0-indexed) gets position (i/8)+1.

**Algorithm:**
1. Count frequencies of each letter.
2. Sort frequencies descending.
3. For each frequency f at rank i: add f * (i/8 + 1) to result.
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(n) — count + O(26 log 26) sort = O(n) |
| Space | O(1) — fixed alphabet |
