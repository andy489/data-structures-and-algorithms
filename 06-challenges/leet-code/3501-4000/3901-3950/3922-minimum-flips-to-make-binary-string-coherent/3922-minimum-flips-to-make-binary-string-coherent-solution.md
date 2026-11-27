# 3922. Minimum Flips to Make Binary String Coherent — Solution

## Approach: Prefix/Suffix Counting

A string is coherent if it has no `"011"` or `"110"` subsequences. Analyzing when these subsequences cannot appear:
- `"011"` requires a `0` before two `1`s — blocked if all `0`s come after all `1`s.
- `"110"` requires two `1`s before a `0` — blocked if all `1`s come after all `0`s.

A coherent string must be of the form `1...10...0` (some 1s followed by some 0s), including all-0s or all-1s. For any split point `i` (0 to n), the string becomes all `1`s in `[0, i)` and all `0`s in `[i, n)`. The cost is:
- Number of `0`s in `[0, i)` (need to flip to `1`)
- Number of `1`s in `[i, n)` (need to flip to `0`)

We precompute prefix counts of `0`s and suffix counts of `1`s, then try all split points and return the minimum.

## Complexity

- **Time:** O(n) — two passes for prefix/suffix arrays plus one pass for minimum
- **Space:** O(n) — prefix and suffix arrays
