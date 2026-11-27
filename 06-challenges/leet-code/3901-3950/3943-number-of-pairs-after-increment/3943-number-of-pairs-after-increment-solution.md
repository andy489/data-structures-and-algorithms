# 3943. Number of Pairs After Increment

## Approach

For type 1 queries (range updates on `nums2`) use a Binary Indexed Tree (Fenwick Tree) to track the increments as a prefix sum difference array — apply range add with two point updates.

For type 2 queries (count pairs), for each `nums1[j]` (there are at most 5), compute `target = tot - nums1[j]` and count how many elements in `nums2` equal `target`. Since `nums2` can be large and values change, maintain a frequency map for the current state of `nums2`.

Since `nums1.length <= 5`, each type 2 query takes O(5 * log(maxVal)) with appropriate data structures.

For counting: use a sorted structure or frequency array. Since values can be large after increments, use a HashMap. For range increments, use a lazy approach: add to a "global delta" only when the range covers all of `nums2`, and handle partial updates differently. 

Given the small size of `nums2` (up to 5*10^4), for each type 1 query, we can use a Fenwick tree to represent cumulative additions. For type 2, iterate over `nums1` elements and binary search in a sorted `nums2` with prefix sums.

Actually since `nums1.length <= 5`, for type 2 we can rebuild. Use Fenwick tree for lazy range add, iterate nums2 to get current values on demand — but this would be O(n) per type 2 query which is 5*10^4 * 5*10^4 = too slow.

Better: maintain a sorted structure. When all elements in a range are shifted uniformly, use a segment tree with lazy propagation. For counting, since `nums1` is small, use a sorted nums2 + BIT for counting equals after shifts.

## Complexity

- **Time:** O((n + q) log n) with segment tree + binary search
- **Space:** O(n) — for segment tree
