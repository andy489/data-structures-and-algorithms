# 208. Implement Trie (Prefix Tree) — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/implement-trie-prefix-tree/

---

## Solution: Array-backed TrieNode — O(m) per operation, O(ALPHABET · m · n) space

**Idea:** Each `TrieNode` holds a fixed-size array of 26 children (one per lowercase letter) and a boolean `isEnd` flag. Traversal follows child pointers character by character; absence of a child means the word/prefix is not present.

**Algorithm — insert(word):**
1. Start at root.
2. For each character `c`: if `children[c - 'a']` is null, create a new node. Advance to that child.
3. Mark the final node's `isEnd = true`.

**Algorithm — search(word):**
1. Traverse like `insert` but return `false` if any child is missing.
2. Return `node.isEnd` at the final character.

**Algorithm — startsWith(prefix):**
1. Same traversal; return `false` if any child is missing.
2. Return `true` on successful traversal (no `isEnd` check needed).

**Complexity:**

| | |
|---|---|
| Time | O(m) per call — `m` = length of word/prefix |
| Space | O(ALPHABET · m · n) — 26 children per node, `n` words of average length `m` |
