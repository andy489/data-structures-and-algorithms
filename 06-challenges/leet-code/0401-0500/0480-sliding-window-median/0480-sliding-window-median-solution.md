# 480. Sliding Window Median — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sliding-window-median/

---

## Solution: Two Heaps with Lazy Deletion — O(N log k) time, O(k) space

**Idea:** Maintain a max-heap (lower half) and a min-heap (upper half) of equal size (±1). For each step: add new element, remove outgoing element using a lazy deletion map, rebalance heaps, then read median.

**Algorithm:**
1. Use `maxHeap` (lower half) and `minHeap` (upper half).
2. Add: insert into appropriate heap, rebalance so sizes differ by at most 1.
3. Remove: mark in `toRemove` map; prune tops of heaps lazily.
4. Median: if sizes equal → average of tops; else → top of larger heap.

**Complexity:**

| | |
|---|---|
| Time | O(N log k) — each add/remove is O(log k) |
| Space | O(k) — heaps hold at most k elements |
