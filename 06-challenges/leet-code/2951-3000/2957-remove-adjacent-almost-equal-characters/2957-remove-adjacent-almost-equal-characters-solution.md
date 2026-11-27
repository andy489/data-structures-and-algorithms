# 2957. Remove Adjacent Almost-Equal Characters — Solution

## Approach: Greedy — Change Every Other Conflicting Position

Iterate left to right. When `word[i]` and `word[i-1]` are almost-equal (|a - b| <= 1), we must change one of them. Greedily change `word[i]` (the right one) so it doesn't conflict with either neighbor. We can always set it to a character that doesn't conflict (e.g., 'a', 'c', or similar). Then skip `i+1` since we just changed `word[i]`, moving to `i+2` effectively.

The key insight: when we find a conflict at position i, we change position i and jump to i+2 (since the changed character at i is "safe" with respect to i+1 — we just need to check i+1 against i+2 normally).

## Complexity

| | Time | Space |
|---|---|---|
| Single pass | O(n) | O(1) |
