# 1044. Longest Duplicate Substring — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/longest-duplicate-substring/

---

## Solution: Binary Search + Rabin-Karp Rolling Hash — O(n log n) time, O(n) space

**Idea:** Binary search on length L. For each L, use rolling hash to check if any substring of length L appears twice.

**Algorithm:**
1. Binary search L from 1 to n-1.
2. For given L, compute rolling hashes of all substrings of length L.
3. If any hash repeats (with collision check), L is achievable.
4. Track the longest found.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
