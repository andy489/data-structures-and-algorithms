# 386. Lexicographical Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/lexicographical-numbers/

---

## Solution: DFS Trie Traversal — O(n) time, O(1) extra space

**Idea:** Simulate a DFS on a 10-ary trie rooted at digits 1–9. At each node `cur`: try to go deeper (`cur * 10`) first, then advance to the next sibling (`cur + 1`), backing up when needed.

**Algorithm:**
1. Start at `cur = 1`.
2. For `n` iterations: add `cur`, try `cur * 10` (go deeper), else try `cur + 1` (next sibling), handling the case where `cur + 1` overflows to the parent's next sibling.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits each number once |
| Space | O(1) extra (output not counted) |
