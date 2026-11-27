# 648. Replace Words — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/replace-words/

---

## Solution: Hash Set + Prefix Search — O(n·L) time, O(d) space

**Idea:** Store all roots in a HashSet. For each word in the sentence, check prefixes from length 1 upward; replace with the first matching root found.

**Complexity:**

| | |
|---|---|
| Time | O(n·L) — n words, L max root length |
| Space | O(d) — d = dictionary size |
