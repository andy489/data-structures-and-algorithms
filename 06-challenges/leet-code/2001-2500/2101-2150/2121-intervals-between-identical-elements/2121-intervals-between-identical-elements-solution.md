# 2121. Intervals Between Identical Elements — Solution

**Link:** https://leetcode.com/problems/intervals-between-identical-elements/

## Approach: Prefix Sum per Value Group

For each value, collect its indices: `[i0, i1, i2, ..., ik]`.

For index `ij` in the group, the sum of `|ij - ix|` for all `x != j` equals:
- Sum of `(ij - ix)` for all `ix < ij` (left contribution): `j * ij - prefixSum[j]`
- Sum of `(ix - ij)` for all `ix > ij` (right contribution): `(suffixSum[j] - ij) - (k - j - 1) * ij` simplified as `(totalSum - prefixSum[j+1]) - (k - j - 1) * ij`

Group indices by value, compute prefix sums, then fill each index's answer in O(1).

## Complexity

| | Time | Space |
|---|---|---|
| **Prefix Sum** | O(n) | O(n) |
