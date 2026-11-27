# 1519. Number of Nodes in the Sub-Tree With the Same Label — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

---

## Solution: DFS Post-order with Frequency Arrays — O(n * 26) time, O(n * 26) space

**Idea:** Do a post-order DFS. At each node, aggregate the frequency arrays from all children. Then `ans[node] = freq[node][label[node]]`.

**Algorithm:**
1. Build adjacency list.
2. DFS from root (node 0), tracking parent to avoid revisiting.
3. At each node, start with a freq array of 26 zeros, set `freq[label_char]++`.
4. For each child, recursively get child freq array, merge into current node's freq.
5. `ans[node] = freq[label[node] - 'a']`.
6. Return freq array upward.

**Complexity:**

| | |
|---|---|
| Time | O(n * 26) — merging 26-element arrays for each node |
| Space | O(n * 26) — recursion stack + freq arrays |
