# 890. Find and Replace Pattern — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-and-replace-pattern/

---

## Solution: Bijection Check — O(n * m) time, O(m) space

**Idea:** A word matches if there's a bijection between word chars and pattern chars. Check both directions: word→pattern and pattern→word must be consistent.

**Complexity:**

| | |
|---|---|
| Time | O(n * m) — n words, m pattern length |
| Space | O(m) |
