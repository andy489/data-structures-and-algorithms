# 2149. Rearrange Array Elements by Sign — Solution

## Approach: Two-Pointer Merge

**Key insight:** Separate positive and negative integers while preserving their relative order, then interleave them: result[0] = positive[0], result[1] = negative[0], result[2] = positive[1], result[3] = negative[1], etc.

**Algorithm:**
1. Create result array of size n.
2. Use two pointers: `posIdx = 0` for even positions, `negIdx = 1` for odd positions.
3. Iterate through nums, placing positives at even indices and negatives at odd indices, advancing the respective pointer by 2 each time.

## Complexity

| | Time | Space |
|---|---|---|
| Single pass | O(n) | O(n) for result array |
| **Total** | **O(n)** | **O(n)** |
