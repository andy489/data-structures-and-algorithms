# Solution: Find the Occurrence of First Almost Equal Substring

## Approach: Z-Function (KMP-based)

Use the Z-function to efficiently determine the longest prefix match from both directions.

1. Build Z-array for `pattern + "#" + s` to get `zPre[i]`: the longest prefix of `pattern` matching at position `i` in `s`.
2. Build Z-array for `rev(pattern) + "#" + rev(s)` to get `zSuf[i]`: the longest suffix of `pattern` matching at the end of each position in `s`.

For each starting index `i` in `s`, the substring `s[i..i+m-1]` is almost equal to `pattern` if:
- Exact match: `zPre[i] >= m`, or
- One change: there exists a split point where `zPre[i] + zSuf[i] >= m - 1`

Specifically, if `zPre` match from the start is `p`, and `zSuf` match from the end is `q`, and `p + q >= m - 1`, it means only 1 position in the middle differs.

## Complexity

- **Time:** O(n + m) for Z-function construction and linear scan.
- **Space:** O(n + m).
