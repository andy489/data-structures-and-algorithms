# 522. Longest Uncommon Subsequence II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-uncommon-subsequence-ii/

---

## Solution: Brute Force with Subsequence Check — O(n² · L) time, O(1) space

**Idea:** For each string, check if it is a subsequence of any other string in the array. If it is not a subsequence of any other string, it is a valid candidate. Track the longest such candidate.

**Algorithm:**
1. Sort strings by length descending so we find the longest first.
2. For each string `s`, check whether `s` is a subsequence of any other string in the array.
3. A string `s` is "uncommon" if it is NOT a subsequence of any other string.
4. Return the maximum length found, or `-1`.

**Complexity:**

| | |
|---|---|
| Time | O(n² · L) — n strings, each compared against n others with O(L) subsequence check |
| Space | O(1) |
