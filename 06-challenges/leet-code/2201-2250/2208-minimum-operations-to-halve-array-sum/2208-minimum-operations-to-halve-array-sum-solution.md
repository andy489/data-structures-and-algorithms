# 2208. Minimum Operations to Halve Array Sum

## Approach

Greedy: always halve the largest element. This maximizes the reduction per operation.

Use a max-heap (priority queue). Keep track of total sum and target (sum / 2). Each operation:
1. Pop the max element.
2. Halve it, compute the reduction.
3. Push halved value back.
4. Accumulate reduction; stop when >= target.

**Time Complexity:** O(n log n) on average (number of operations is bounded)  
**Space Complexity:** O(n)
