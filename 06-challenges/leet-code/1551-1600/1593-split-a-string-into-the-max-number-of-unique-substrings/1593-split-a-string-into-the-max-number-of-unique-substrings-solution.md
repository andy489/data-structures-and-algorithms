# 1593. Split a String Into the Max Number of Unique Substrings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/

---

## Solution: Backtracking — O(n * 2^n) time, O(n) space

**Idea:** Backtrack over all ways to split the string, using a set to enforce uniqueness. Prune when remaining characters plus current count cannot exceed current best.

**Algorithm:**
1. Backtrack from index `start`, trying all splits `s[start..end]`.
2. Skip substrings already in `used`.
3. Prune: if `remaining + used.size() <= maxCount`, cut the branch.
4. Update `maxCount` when `start == n`.

**Complexity:**

| | |
|---|---|
| Time | O(n * 2^n) — at most 2^n splits, each O(n) string operation |
| Space | O(n) — recursion depth and set size at most n |
