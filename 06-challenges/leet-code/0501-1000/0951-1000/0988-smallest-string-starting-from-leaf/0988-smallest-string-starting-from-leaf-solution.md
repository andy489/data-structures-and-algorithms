# 988. Smallest String Starting From Leaf — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-string-starting-from-leaf/

---

## Solution: DFS + String Building — O(n²) time, O(n) space

**Idea:** DFS, building the string from leaf to root. At leaves, compare and update minimum.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — string reversal at each leaf |
| Space | O(n) — recursion + path |
