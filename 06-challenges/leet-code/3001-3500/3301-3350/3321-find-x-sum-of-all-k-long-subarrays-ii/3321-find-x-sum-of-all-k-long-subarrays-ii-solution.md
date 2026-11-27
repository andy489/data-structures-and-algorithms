# Solution: Find X-Sum of All K-Long Subarrays II

## Approach: Two Sorted Sets (TreeSet) Sliding Window

For large `n` (up to 10^5), brute force is O(n * k log k) which may be too slow. Use two ordered sets to maintain the top-x and bottom elements.

**Data structure:** Maintain:
- `topSet`: sorted set of `(freq, value)` pairs for the top-x elements (by frequency desc, value desc).
- `bottomSet`: sorted set for the remaining elements.
- `topSum`: current sum of all elements in topSet (freq * value for each element).

**Invariant:** topSet always contains exactly `min(x, distinct_count)` elements.

**Operations on slide:**
- When adding a new element to the window, update its frequency and rebalance top/bottom.
- When removing an old element from the window, update its frequency and rebalance.

After each adjustment, if topSet.size() < x and bottomSet is non-empty, move the max of bottomSet to topSet. If topSet.size() > x, move the min of topSet to bottomSet.

## Complexity

- **Time:** O(n log n) — each element is inserted/removed from sets O(log n) times.
- **Space:** O(k) for the frequency map and sets.
