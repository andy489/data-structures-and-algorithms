# 521. Longest Uncommon Subsequence I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/longest-uncommon-subsequence-i/

---

## Solution: Observation — O(1) time, O(1) space

**Idea:** If `a == b`, every subsequence of one is also a subsequence of the other, so return `-1`. Otherwise, the longer string is itself the longest uncommon subsequence (it can't be a subsequence of the shorter one). If equal length but unequal content, either full string works.

**Algorithm:**
1. If `a.equals(b)`, return `-1`.
2. Otherwise return `Math.max(a.length(), b.length())`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — string comparison |
| Space | O(1) |
