# Solution: Find Longest Special Substring That Occurs Thrice II

## Approach: Run-Length Encoding + Binary Search

For each character c, collect all run lengths. For a given target length L, the count of "c repeated L times" is sum over all runs of max(0, run_len - L + 1).

Binary search on L for each character. The answer is the maximum valid L across all characters.

## Complexity

| | Time | Space |
|---|---|---|
| **Run Encoding + Binary Search** | **O(n + 26 log n)** | **O(n)** |

## Key Insight

For large n (up to 5×10^5), the O(n²) brute force won't work. Instead, extract run lengths in O(n), then for each of the 26 characters binary search over possible lengths L (1 to max_run). For each L, count in O(#runs) ≤ O(n).
