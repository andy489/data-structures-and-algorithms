# Solution: Maximum Square Area by Removing Fences From a Field

## Approach: Collect All Gaps, Find Common Gap

Add boundary positions (1 and m) to hFences, and (1 and n) to vFences. Sort them. Compute all pairwise differences between fence positions (gaps) for both horizontal and vertical directions. Find the intersection (common gaps that exist in both directions). The largest common gap gives the maximum square side length.

## Complexity

| | Time | Space |
|---|---|---|
| **Pairwise Differences + Set Intersection** | **O(H² + V²)** | **O(H² + V²)** |

where H = hFences.length + 2, V = vFences.length + 2 (at most ~602 each).

## Key Insight

A square can be formed if and only if the same gap length exists as both a valid horizontal span and a valid vertical span. Collect all possible gaps from fence positions in each direction, then find the largest common value.
