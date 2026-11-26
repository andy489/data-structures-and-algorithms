# 1541. Minimum Insertions to Balance a Parentheses String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

---

## Solution: Greedy Stack Simulation — O(n) time, O(1) space

**Idea:** Track open parentheses count. For each ')' seen, check if the next character is also ')' (forming "))"). If not, insert one ')'. Then match against an open '(': if no open available, insert one '('. After processing, each remaining unmatched '(' needs two ')' inserted.

**Algorithm:**
1. For '(': increment open count.
2. For ')': check if followed by another ')'; if not, insert one (insertions++), advance one position.
   - If open > 0, decrement open (matched).
   - Otherwise, insert a '(' (insertions++).
3. At end: `insertions += open * 2` for unmatched opens.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only counters |
