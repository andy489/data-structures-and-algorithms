# Solution: Apply Operations to Maximize Frequency Score

## Approach: Sort + Sliding Window

Sort the array. The optimal strategy is to pick a window of consecutive elements and move them all toward the median of the window (which minimizes cost). Use a prefix sum to efficiently compute the cost of making all elements in a window equal to the median.

Binary search on the window size (or use two-pointer sliding window): expand the window as long as the cost to unify elements doesn't exceed k.

**Cost to make a[l..r] all equal to a[mid]:**
- Left half cost = `a[mid] * (mid - l) - prefix[mid] + prefix[l]`
- Right half cost = `prefix[r+1] - prefix[mid+1] - a[mid] * (r - mid)`

## Complexity

| | Time | Space |
|---|---|---|
| **Sort + Sliding Window + Prefix Sum** | **O(n log n)** | **O(n)** |

## Key Insight

After sorting, any optimal group of elements being unified are consecutive. With prefix sums, we can compute the minimum cost to unify a window [l, r] to the median in O(1).
