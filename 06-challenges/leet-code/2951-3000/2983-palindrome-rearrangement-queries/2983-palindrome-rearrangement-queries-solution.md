# Solution: Palindrome Rearrangement Queries

## Approach: Prefix Sum of Character Frequencies

For s to be a palindrome, s[i] must equal s[n-1-i] for all i. The left half is indices [0, n/2 - 1] and the right half is [n/2, n-1].

For each query [a, b, c, d]:
1. Reflect the right half range [c, d] to left-half indices: c' = n-1-d, d' = n-1-c.
2. The union of the left rearrangement window [a, b] and the reflected right window [c', d'] covers some positions.
3. Positions NOT covered by either window must already be palindrome pairs (s[i] == s[n-1-i]).
4. For covered positions, check if the combined character multiset can be rearranged to satisfy palindrome.

Use prefix sums over character counts to efficiently compute character frequency differences.

## Complexity

| | Time | Space |
|---|---|---|
| **Prefix Sum + Per Query O(26)** | **O(n * 26 + q * 26)** | **O(n * 26)** |

## Key Insight

Build prefix frequency arrays for both halves. For each query, positions outside both windows must already match. For positions inside the union, check if the total character counts (from both halves) can pair up correctly.
