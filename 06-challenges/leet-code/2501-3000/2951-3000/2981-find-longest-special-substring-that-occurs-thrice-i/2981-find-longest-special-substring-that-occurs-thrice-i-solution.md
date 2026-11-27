# Solution: Find Longest Special Substring That Occurs Thrice I

## Approach: Brute Force Count

Since n ≤ 50, enumerate all special substrings (single character runs) and count their occurrences. A special substring of length L using character c occurs in every run of c of length >= L. Count using a frequency map.

Binary search on the answer length: for a given length len, check if any single-character substring of that length appears at least 3 times.

## Complexity

| | Time | Space |
|---|---|---|
| **Brute Force** | **O(n²)** | **O(n)** |

## Key Insight

For a fixed character c and length L, the number of occurrences of "ccc...c" (L times) is sum of max(0, run_len - L + 1) for each maximal run of c. Use this to binary search or iterate over lengths.
