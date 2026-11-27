# Solution: Substring Matching Pattern

## Approach

Split the pattern on '*' to get a prefix part and a suffix part.

Search for the prefix in s, then check if the suffix appears after the prefix position.

Specifically: find the smallest index where prefix occurs. After the prefix, check if suffix occurs.

We just need: some index i where s[i..i+len(prefix)-1] == prefix, and some j >= i+len(prefix) where s[j..j+len(suffix)-1] == suffix.

Simple O(n^2): try all split points in s.

## Complexity

| | Complexity |
|---|---|
| Time | O(n * |p|) |
| Space | O(|p|) |
