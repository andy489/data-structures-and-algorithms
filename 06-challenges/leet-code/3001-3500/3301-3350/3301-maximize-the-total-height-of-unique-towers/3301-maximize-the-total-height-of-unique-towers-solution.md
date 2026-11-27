# Solution: Maximize the Total Height of Unique Towers

## Approach: Greedy (Sort and Assign from Largest)

Sort the towers by their maximum allowed height in descending order. Greedily assign the largest possible distinct height to each tower. For each tower in sorted order, assign `min(maximumHeight[i], prev - 1)` where `prev` is the previously assigned height. If this value drops below 1, return `-1`.

**Steps:**
1. Sort `maximumHeight` in descending order.
2. Initialize `prev = maximumHeight[0]`, add it to `result`.
3. For each subsequent element, set `h = min(maximumHeight[i], prev - 1)`. If `h < 1`, return `-1`. Otherwise add `h` to result, update `prev = h`.
4. Return `result`.

## Complexity

- **Time:** O(n log n) for sorting.
- **Space:** O(1) extra (excluding sort space).
