# 524. Longest Word in Dictionary through Deleting — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

---

## Solution: Subsequence Check — O(d · n) time, O(1) space

**Idea:** For each word in the dictionary, check if it is a subsequence of `s`. Among all valid words, keep the longest one (break ties by lexicographic order).

**Algorithm:**
1. Initialize `result = ""`.
2. For each word in dictionary, check if it is a subsequence of `s`.
3. If valid and (longer than result, or same length but lexicographically smaller), update result.
4. Return result.

**Complexity:**

| | |
|---|---|
| Time | O(d · n) — d = dictionary size, n = s.length |
| Space | O(1) |
