# 2569. Handling Sum Queries After Update — Solution

## Approach: Segment Tree with Lazy Propagation

**Key Operations:**
1. **Type 1:** Range flip of `nums1[l..r]` — toggle 0/1 values.
2. **Type 2:** Add `sum(nums1) * p` to `sum(nums2)`.
3. **Type 3:** Return current `sum(nums2)`.

**Key Insight:** We only need `sum(nums1)` for type 2 queries (not individual values). So we build a segment tree on `nums1` that supports:
- Range flip (lazy propagation): flip all values in a range.
- Range sum query: get the count of 1s in a range.

For type 2, we increment a running `sum2` variable by `treeSum * p` where `treeSum` is the count of 1s in `nums1`.

**Lazy Segment Tree:**
- Each node stores sum (count of 1s) and lazy flip flag.
- Push down: propagate flip to children.
- Range flip: flip(l, r) updates sum of a range = (length - old_sum).

## Complexity

- **Time:** O((n + q) log n) — each query involves O(log n) segment tree operations
- **Space:** O(n) — for the segment tree
