# 212. Word Search II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/word-search-ii/

---

## Solution: Trie + DFS Backtracking — O(m·n·4·3^(L-1)) time, O(W·L) space

**Idea:** Build a Trie from all words. DFS from every cell; at each step walk the Trie instead of matching a single word. Prune branches where no Trie path exists. Remove a found word from the Trie to avoid duplicates.

**Algorithm:**
1. Insert all words into the Trie.
2. For each cell `(r, c)` call DFS with the root.
3. DFS: if current Trie node has `word != null`, record it and clear it to avoid duplicates.
4. Mark the cell visited (`board[r][c] = '#'`), explore 4 directions, restore cell.
5. Optionally prune leaf Trie nodes after finding a word.

**Complexity:**

| | |
|---|---|
| Time | O(m·n·4·3^(L-1)) where L = max word length |
| Space | O(W·L) for Trie + O(L) recursion stack |
