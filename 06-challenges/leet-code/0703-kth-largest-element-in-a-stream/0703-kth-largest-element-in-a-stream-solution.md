# 703. Kth Largest Element in a Stream — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/kth-largest-element-in-a-stream/

---

## Solution: Min-Heap of size k — O(n log k) init, O(log k) add, O(k) space

**Idea:** Maintain a min-heap of exactly k elements. The heap's minimum (top) is always the kth largest seen so far. When adding a new element, push it in and pop if size exceeds k.

**Algorithm:**
1. Initialize a min-heap with nums, then trim to size k by polling excess elements.
2. `add(val)`: push val onto heap; if size > k, poll the minimum; return the heap's minimum.

**Complexity:**

| | |
|---|---|
| Time | O(n log k) init, O(log k) per add |
| Space | O(k) — heap stores k elements |
