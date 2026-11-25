# 997. Find the Town Judge — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-town-judge/

---

## Solution: Trust Score — O(n+T) time, O(n) space

**Idea:** Score = in-degree - out-degree. Town judge has score n-1.

**Complexity:**

| | |
|---|---|
| Time | O(n+T) — T = trust edges |
| Space | O(n) |
