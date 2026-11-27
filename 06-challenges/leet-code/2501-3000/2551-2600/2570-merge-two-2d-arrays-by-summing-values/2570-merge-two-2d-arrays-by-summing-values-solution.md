# 2570. Merge Two 2D Arrays by Summing Values — Solution

## Approach: Two Pointers (Merge)

Both arrays are sorted by id, so we can use a merge-style two-pointer approach similar to merge sort.

**Algorithm:**
1. Use two pointers `i` and `j` for `nums1` and `nums2`.
2. At each step, compare the ids at `nums1[i]` and `nums2[j]`:
   - If equal: add `[id, val1 + val2]` to result, advance both.
   - If `nums1[i] < nums2[j]`: add `nums1[i]`, advance `i`.
   - Otherwise: add `nums2[j]`, advance `j`.
3. Append remaining elements from either array.

## Complexity

- **Time:** O(m + n) — single pass through both arrays
- **Space:** O(m + n) — for the result array
