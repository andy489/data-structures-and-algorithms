# 2558. Take Gifts From the Richest Pile — Solution

## Approach: Max-Heap (Priority Queue)

Use a max-heap to always access the largest pile in O(log n) time.

**Algorithm:**
1. Insert all pile values into a max-heap.
2. For each of the `k` seconds:
   - Extract the maximum value.
   - Replace it with `floor(sqrt(max))`.
   - Re-insert into the heap.
3. Sum all remaining values in the heap.

## Complexity

- **Time:** O((n + k) log n) — building heap plus k operations each O(log n)
- **Space:** O(n) — for the heap
