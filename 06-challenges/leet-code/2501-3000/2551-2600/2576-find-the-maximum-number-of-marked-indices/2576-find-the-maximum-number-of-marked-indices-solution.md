# Solution: 2576. Find the Maximum Number of Marked Indices

## Approach: Sorting + Two Pointers / Binary Search

**Key Observation:** To maximize the number of marked pairs, we can pair the smallest values with the largest values. Specifically, if we sort `nums`, the optimal strategy is to pair `nums[i]` with `nums[n/2 + i]`.

**Proof:** If we can mark `k` pairs, the best pairing uses the `k` smallest values as the "small" elements and the `k` largest values as the "large" elements. Among these, we pair `nums[i]` with `nums[n-k+i]`.

**Binary Search on k:**
- Binary search on the number of pairs `k` (from 0 to n/2).
- For a given `k`, check if we can form `k` valid pairs: pair `nums[i]` with `nums[n-k+i]` for `i` in `[0, k-1]`.
- A pairing is valid if `2 * nums[i] <= nums[n-k+i]` for all `i in [0, k-1]`.
- Find the maximum valid `k`.

**Two Pointer Approach (simpler):**
- Sort `nums`.
- Use pointer `left` starting at 0 and `right` starting at `n/2`.
- For each position in the right half, check if `2 * nums[left] <= nums[right]`. If yes, advance both pointers; otherwise advance only `right`.
- Count successful pairs.

## Complexity

- **Time:** O(n log n) for sorting
- **Space:** O(1) extra
