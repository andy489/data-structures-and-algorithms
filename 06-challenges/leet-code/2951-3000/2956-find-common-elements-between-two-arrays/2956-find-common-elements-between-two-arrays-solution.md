# 2956. Find Common Elements Between Two Arrays — Solution

## Approach: HashSet Lookup

Build a set from each array. Then count how many elements of nums1 appear in the set of nums2, and vice versa.

## Complexity

| | Time | Space |
|---|---|---|
| Build sets + scan | O(n + m) | O(n + m) |
