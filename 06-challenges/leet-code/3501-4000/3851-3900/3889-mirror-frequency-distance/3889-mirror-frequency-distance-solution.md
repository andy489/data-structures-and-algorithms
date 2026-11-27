# Solution: 3889. Mirror Frequency Distance

## Approach: Frequency Count + Mirror Pairing

Build a frequency map of all characters. Then iterate over each distinct mirror pair exactly once and accumulate the absolute frequency differences.

### Algorithm

1. Count the frequency of every character in `s`.
2. For letters: mirror of `c` is `(char)('a' + 'z' - c)`. Iterate pairs `(a,z), (b,y), ..., (m,n)` — only 13 pairs.
3. For digits: mirror of `c` is `(char)('0' + '9' - c)`. Iterate pairs `(0,9), (1,8), ..., (4,5)` — only 5 pairs.
4. For each pair, add `|freq[c] - freq[mirror(c)]|` to the result.

Note: If `c == mirror(c)` (which cannot happen for letters or digits since they always have distinct mirrors), we would count it only once. For letters a-z, 'a' mirrors 'z' (different), 'm' mirrors 'n' (different), so there's no self-mirror case.

### Edge Cases

- Characters in `s` that have zero frequency still form mirror pairs but contribute `|0 - freq(mirror)| = freq(mirror)`.
- Self-mirror characters don't exist in lowercase letters or digits.

## Complexity

- **Time:** O(N + 36) = O(N) where N is string length
- **Space:** O(36) = O(1) for the frequency map
