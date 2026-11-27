# Solution: Minimum Number Game

## Approach: Sort

Sort the array. After sorting, every consecutive pair (at positions 2i, 2i+1) represents Alice's pick and Bob's pick in round i. In each pair, Bob appends his pick (smaller index = picked by Alice) first, then Alice.

After sorting, for each round's pair at indices 2i and 2i+1:
- Alice picks nums[2i], Bob picks nums[2i+1]
- Bob appends first (nums[2i+1]), then Alice (nums[2i])

## Complexity

| | Time | Space |
|---|---|---|
| **Sort** | **O(n log n)** | **O(n)** |

## Key Insight

After sorting in ascending order, Alice always picks the smaller of two consecutive sorted elements (even-indexed), Bob picks the larger (odd-indexed), then Bob appends first, Alice second — so output is nums[1], nums[0], nums[3], nums[2], ...
