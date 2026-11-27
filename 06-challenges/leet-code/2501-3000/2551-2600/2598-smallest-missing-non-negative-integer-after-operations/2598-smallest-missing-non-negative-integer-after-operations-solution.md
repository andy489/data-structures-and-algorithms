# Solution: 2598. Smallest Missing Non-negative Integer After Operations

## Approach

Each element can be shifted by any multiple of `value` (positive or negative). So each element's "reachable residue class" modulo `value` is `((num % value) + value) % value`.

For the MEX to be maximized, we want to cover as many non-negative integers starting from 0 as possible. Group elements by their residue modulo `value`. For each residue class `r`, the elements can cover `r, r + value, r + 2*value, ...`.

For each residue, count how many elements have that residue. These elements can cover `r, r + value, r + 2*value, ...` up to `count` values in that progression. The MEX is the first non-negative integer not covered.

Iterate MEX starting from 0: for each candidate MEX, check if it can be covered.

## Complexity

- **Time:** O(n + MEX) where MEX is at most n
- **Space:** O(value) for grouping by residue
