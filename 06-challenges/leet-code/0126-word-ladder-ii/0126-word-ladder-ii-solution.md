# 126. Word Ladder II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/word-ladder-ii/

---

## Solution: BFS DAG + DFS Backtrack — O(n · L · 26 + P) time, O(n · L) space

**Idea:** Run BFS from `beginWord` to find the shortest path length and record, for each word, all its **parents** (predecessors at the previous BFS level). This builds a DAG of all shortest paths. Then DFS/backtrack from `endWord` through the parent map back to `beginWord`, reversing each collected path.

Crucially, once a word is reached at level `d`, it must not be re-visited at a deeper level — but it *can* be reached from multiple parents at the same level. So we remove a word from the available set only when we finish processing its entire BFS level, not immediately when first seen.

**Algorithm:**
1. Put all words into a set `wordSet`. If `endWord ∉ wordSet`, return `[]`.
2. BFS: maintain a `parents` map `word → set<parent>` and a `currentLevel` set.
   - Start: `currentLevel = {beginWord}`.
   - Each round: for every word in `currentLevel`, try all single-letter substitutions; if the neighbor is in `wordSet`, record it as reachable and add its parent. After processing the full level, remove all `currentLevel` words from `wordSet` to prevent revisiting.
   - Stop when `endWord` appears in the next level.
3. DFS from `endWord`: follow `parents` back to `beginWord`, building paths. Reverse and collect.

**Complexity:**

| | |
|---|---|
| Time  | O(n · L · 26 + P) — BFS tries 26 substitutions per position per word; P = total length of all output paths |
| Space | O(n · L) — word set, parents map, recursion stack |

where `n` = number of words, `L` = word length.
