# 502. IPO — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/ipo/

---

## Solution: Greedy + Min-heap + Max-heap — O(n log n) time, O(n) space

**Idea:** At each step, among all affordable projects (capital[i] <= current w), pick the one with maximum profit. Use a min-heap sorted by capital to efficiently unlock affordable projects, and a max-heap of profits to pick the best.

**Algorithm:**
1. Sort projects by capital into a min-heap.
2. Repeat k times:
   - Push all projects with capital <= w onto a max-heap by profit.
   - If heap is empty, break (no affordable project).
   - Pop the highest-profit project; add its profit to w.
3. Return w.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — heap operations |
| Space | O(n) — heaps |
