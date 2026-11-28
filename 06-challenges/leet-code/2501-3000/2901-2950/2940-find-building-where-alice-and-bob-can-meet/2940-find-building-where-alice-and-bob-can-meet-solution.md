# 2940. Find Building Where Alice and Bob Can Meet — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/

---

## Solution: Offline Queries + Min-Heap — O((n + q) log n) time, O(n + q) space

**Idea:** For each query [a, b] with a <= b:
- If a == b or heights[a] < heights[b]: answer is b immediately.
- Otherwise: we need the first index j > b such that heights[j] > max(heights[a], heights[b]).

Group pending queries by their right endpoint b. Process buildings left to right. When at index i, resolve all pending queries whose threshold we can satisfy (heap minimum threshold < heights[i]). Use a min-heap ordered by threshold height; store (threshold, query_index).

**Algorithm:**
1. Normalize each query so a <= b.
2. For immediate answers (a == b or h[a] < h[b]): store b.
3. Otherwise: push (max(h[a], h[b]), query_idx) into bucket[b].
4. Sweep index i from 0 to n-1: add bucket[i] entries to heap, then pop all heap entries with threshold < h[i] and record answer i.
5. Any remaining heap entries get answer -1.

**Complexity:**

| | |
|---|---|
| Time | O((n + q) log n) |
| Space | O(n + q) |
