# 2559. Count Vowel Strings in Ranges — Solution

## Approach: Prefix Sum

Build a prefix sum array where `prefix[i]` = number of strings in `words[0..i-1]` that start and end with a vowel. Then each query `[l, r]` is answered in O(1) as `prefix[r+1] - prefix[l]`.

**Algorithm:**
1. Build `prefix[0..n]` where `prefix[0] = 0` and `prefix[i] = prefix[i-1] + (1 if words[i-1] starts and ends with a vowel else 0)`.
2. For each query `[l, r]`, return `prefix[r+1] - prefix[l]`.

## Complexity

- **Time:** O(n + q) — O(n) to build prefix sum, O(1) per query
- **Space:** O(n) — for the prefix sum array
