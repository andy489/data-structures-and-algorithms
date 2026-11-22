# 218. The Skyline Problem — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/the-skyline-problem/

---

## Solution: Sweep Line + Max-Heap — O(n log n) time, O(n) space

**Idea:** Convert buildings to events: left edge adds height, right edge removes it. Process events left to right; track the current max height with a max-heap. Whenever the max height changes, emit a key point.

**Algorithm:**
1. For each building `[l, r, h]`: add event `(l, -h)` (start, negative for max-heap sort) and `(r, h)` (end, positive).
2. Sort events: by x; ties — start before end; among starts, taller first; among ends, shorter first.
3. Use a max-heap (or TreeMap with counts). On a start event add `h`; on an end event remove `h`.
4. After each event, if `heap.peek() != prevMax`, emit `[x, heap.peek()]` and update `prevMax`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting + heap operations |
| Space | O(n) — heap |
