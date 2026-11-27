# 2102. Sequentially Ordinal Rank Tracker — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/sequentially-ordinal-rank-tracker/

---

## Solution: Two Heaps (Max-Heap Left + Min-Heap Right) — O(log n) per operation

**Idea:** Maintain two heaps to efficiently track the ith best element:
- `left`: a max-heap of the best `i` locations seen so far (the top i).
- `right`: a min-heap of the remaining (worse) locations.

The `get()` invariant: after the kth `get()` call, `left` contains exactly `k` elements, and `left.peek()` is the kth best location.

**Ordering:** locations are ordered first by score descending, then by name ascending. We define a comparator accordingly.

**Algorithm for `add(name, score)`:**
1. Push the new location into `right` (the min-heap of worse elements, ordered so the min-heap's top is the best of the worse ones).
2. Balance: if `right`'s top is better than `left`'s top (or left is empty after a previous get adjusts), move top of `right` to `left`. More precisely, since `get` calls pop from `left` to `right`, we always keep `left.size == queryCount`.

**Cleaner Two-Heap Invariant:**
- Keep `left` as a max-heap (best-first) with size = number of times `get()` has been called so far.
- `right` is a min-heap of all other elements, ordered so the best element of the remaining is at the top.
- On `add`: push to `right`. Then if `right.peek()` is better than `left.peek()`, swap tops.
- On `get`: move `right.peek()` to `left` (this is the next best). Return `left.peek()`.

**Complexity:**

| | |
|---|---|
| Time | O(log n) per `add` and `get` |
| Space | O(n) — total elements stored |
