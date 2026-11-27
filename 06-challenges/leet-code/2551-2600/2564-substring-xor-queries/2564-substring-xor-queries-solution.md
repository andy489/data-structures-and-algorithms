# 2564. Substring XOR Queries — Solution

## Approach: Precompute All Substrings (up to 32 bits)

**Key Insight:** `val ^ first == second` means `val = first ^ second`. We need to find the shortest substring of `s` whose binary decimal value equals `first ^ second`.

Since integer values are at most 32 bits, we only need to consider substrings of length at most 32.

**Algorithm:**
1. Precompute a map from integer value → `[leftmost start, end]` for all substrings of length 1 to 32.
2. For each query `[first, second]`, compute `target = first ^ second`, look it up in the map.

**Optimization:** Store only the first (leftmost) occurrence of each value.

## Complexity

- **Time:** O(n * 32 + q) — precompute all relevant substrings, then O(1) per query
- **Space:** O(n * 32) — for the hash map
