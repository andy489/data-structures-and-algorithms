# Solution: 2580. Count Ways to Group Overlapping Ranges

## Approach: Merge Overlapping Ranges + Combinatorics

**Step 1: Count connected components of overlapping ranges**

Sort ranges by start. Merge overlapping ranges greedily (track maximum end seen). Count the number of merged groups (connected components).

Two ranges overlap if `start2 <= end1` (after sorting by start).

**Step 2: Count ways to split**

Each connected component (group of overlapping ranges that must stay together) can independently be assigned to group 1 or group 2.

If there are `c` connected components, the answer is `2^c mod (10^9 + 7)`.

## Example

For `ranges = [[1,3],[10,20],[2,5],[4,8]]`:
- After sorting: `[[1,3],[2,5],[4,8],[10,20]]`
- Merging: `[1,8]` and `[10,20]` — 2 components
- Answer: `2^2 = 4` ✓

## Complexity

- **Time:** O(n log n) for sorting
- **Space:** O(1) extra
