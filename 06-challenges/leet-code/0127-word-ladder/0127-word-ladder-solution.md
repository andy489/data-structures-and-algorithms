# 127. Word Ladder — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/word-ladder/

---

## Solution 1: BFS — O(n·L·26) time, O(n·L) space

**Idea:** Standard BFS from `beginWord`. Each level represents one transformation step. Try all 26 substitutions at every position; if the resulting word is in the dictionary set, enqueue it and remove it from the set to prevent revisiting. Return the level count when `endWord` is dequeued.

**Algorithm:**
1. Put all words into a set. If `endWord ∉ set`, return 0.
2. BFS with a queue of `(word, steps)`, starting at `(beginWord, 1)`.
3. For each word dequeued, try all single-letter substitutions. For each neighbor in the set: if it equals `endWord`, return `steps + 1`; otherwise enqueue it with `steps + 1` and remove it from the set.
4. If the queue empties, return 0.

**Complexity:**

| | |
|---|---|
| Time  | O(n·L·26) — for each of n words, try L positions × 26 chars |
| Space | O(n·L) — the word set and queue |

---

## Solution 2: Bidirectional BFS — O(n·L·26) time, O(n·L) space

**Idea:** Expand from both `beginWord` and `endWord` simultaneously, always choosing the smaller frontier to expand. When a word from one frontier is found in the other, the two halves meet and the answer is the sum of their depths. This reduces the effective search radius from `d` to `d/2`, making it significantly faster in practice.

**Algorithm:**
1. Maintain two sets `frontA` (from begin) and `frontB` (from end), and a remaining `wordSet`.
2. Each round: expand the smaller frontier — for each word, try all substitutions; collect neighbors still in `wordSet` into `nextFront`. If any neighbor appears in the **other** frontier, return `steps + 1`.
3. After collecting, remove `nextFront` from `wordSet` and replace the expanded frontier with `nextFront`. Increment steps.
4. If either frontier empties, return 0.

**Complexity:**

| | |
|---|---|
| Time  | O(n·L·26) — same asymptotic, but explores far fewer nodes in practice |
| Space | O(n·L) — two frontier sets + word set |
