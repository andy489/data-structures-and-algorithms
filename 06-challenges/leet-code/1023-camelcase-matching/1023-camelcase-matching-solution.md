# 1023. Camelcase Matching — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/camelcase-matching/

---

## Solution: Two Pointer — O(Q·N) time, O(1) space

**Idea:** For each query, try to match pattern characters in order. Any uppercase character in query that doesn't match the current pattern character means no match.

**Algorithm:**
1. For each query, use pointer j into pattern.
2. For each char c in query: if j < len(pattern) and c == pattern[j], advance j; else if c is uppercase, return false.
3. Return j == len(pattern).

**Complexity:**

| | |
|---|---|
| Time | O(Q·N) — Q queries, N avg length |
| Space | O(1) |
