# 491. Non-decreasing Subsequences — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/non-decreasing-subsequences/

---

## Solution: Backtracking with HashSet Deduplication — O(2^n · n) time, O(2^n · n) space

**Idea:** Use backtracking. At each index, choose to include or skip. Use a HashSet per recursion level to avoid duplicate starts at the same position.

**Algorithm:**
1. DFS from index 0 with current path.
2. At each level, track which values have been used as the starting element to avoid duplicates.
3. If the last element of path <= nums[i], extend and recurse.
4. Collect paths of length >= 2.

**Complexity:**

| | |
|---|---|
| Time | O(2^n · n) — 2^n subsets, each up to length n |
| Space | O(2^n · n) — storing all valid subsequences |
