# 647. Palindromic Substrings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/palindromic-substrings/

---

## Solution: Expand Around Center — O(n²) time, O(1) space

**Idea:** For each center (n odd centers + n-1 even centers), expand outward while characters match, counting each palindrome found.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — O(n) centers, O(n) expansion each |
| Space | O(1) |
