# 1032. Stream of Characters — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stream-of-characters/

---

## Solution: Trie on Reversed Words — O(sum of word lengths) build, O(stream length * max word length) query time, O(sum of word lengths) space

**Idea:** Build a trie of reversed words. Maintain a list of active trie nodes from past queries; for each new char, advance all active nodes and check for word endings.

**Algorithm:**
1. Insert reversed words into trie.
2. On each query(c): advance all current active nodes by c. Add root to active nodes. Check if any active node marks end of word.
3. Remove dead nodes (no child for c).

**Complexity:**

| | |
|---|---|
| Time | O(sum of word lengths) build, O(stream length * max word length) query |
| Space | O(sum of word lengths) |
