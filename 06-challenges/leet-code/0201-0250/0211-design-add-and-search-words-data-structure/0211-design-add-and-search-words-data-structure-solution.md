# 211. Design Add and Search Words Data Structure — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-add-and-search-words-data-structure/

---

## Solution: Trie + DFS for Wildcard — O(m) addWord, O(26^m) worst-case search, O(ALPHABET·m·n) space

**Idea:** Store words in a Trie. For `search`, perform DFS: for a literal character follow the child normally; for `'.'` recurse into all existing children.

**Algorithm:**
1. `addWord`: insert each character into the Trie, mark `isEnd` at the last node.
2. `search(word, node, pos)`: if `pos == word.length` return `node.isEnd`; if `word[pos] == '.'` try every non-null child; otherwise follow the specific child.

**Complexity:**

| | |
|---|---|
| Time | O(m) addWord; O(26^m) search worst-case with many dots |
| Space | O(ALPHABET · m · n) for the Trie |
