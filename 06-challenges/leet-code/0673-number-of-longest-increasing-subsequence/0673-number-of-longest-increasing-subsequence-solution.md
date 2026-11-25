# 673. Number of Longest Increasing Subsequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-longest-increasing-subsequence/

---

## Solution: DP — O(n²) time, O(n) space

**Idea:** Maintain `len[i]` = length of LIS ending at i, and `cnt[i]` = number of such LIS. Transition: for j < i where nums[j] < nums[i], if len[j]+1 > len[i], update len and cnt; if equal, add cnt[j].

**Algorithm:**
1. Initialize `len[i] = 1, cnt[i] = 1`.
2. For each i, check all j < i.
3. Track global max length. Sum cnt[i] where len[i] == maxLen.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n) |
