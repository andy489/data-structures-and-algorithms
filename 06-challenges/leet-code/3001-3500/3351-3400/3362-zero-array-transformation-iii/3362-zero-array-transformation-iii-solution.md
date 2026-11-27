# 3362. Zero Array Transformation III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/zero-array-transformation-iii/

---

## Solution: Greedy + Max-Heap (Sweep Line) — O((n + q) log q) time, O(n + q) space

**Idea:** We want to keep the minimum number of queries needed to zero out `nums`, maximising the number removed. Equivalently: find the minimum set of queries that covers each index `i` at least `nums[i]` times, then the answer is `q - (minimum needed)`.

Greedy approach: sweep from left to right. At each index `i`, we need `nums[i]` total coverage. We greedily pick queries that cover `i` and extend as far right as possible (maximise `r`) — this gives maximum future coverage per query used. Use a max-heap ordered by `r` among queries that start at or before `i`.

**Algorithm:**
1. Sort/index queries by their left endpoint `l`.
2. Use a max-heap of `r` values for queries whose `l <= i`.
3. Track current coverage using a difference array (or running count).
4. At each index `i`:
   - Push all queries with `l <= i` into the max-heap.
   - While `coverage < nums[i]`: pop the query with the largest `r` from the heap, add +1 coverage from `i` to `r` (using diff array), increment used count. If heap is empty and coverage < nums[i], return -1.
5. Update running coverage sum.
6. Return `q - used`.

**Complexity:**

| | |
|---|---|
| Time | O((n + q) log q) — heap operations |
| Space | O(n + q) — difference array and heap |
