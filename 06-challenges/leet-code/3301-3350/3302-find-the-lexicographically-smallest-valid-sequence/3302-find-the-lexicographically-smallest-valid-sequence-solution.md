# Solution: Find the Lexicographically Smallest Valid Sequence

## Approach: Greedy with Suffix Array

We need to pick indices in `word1` to form a sequence "almost equal" to `word2` (at most 1 change allowed). To get the lexicographically smallest sequence:

1. Precompute `suffix[i]`: the longest prefix of `word2` that can be matched as a suffix starting from position `i` in `word1` going right. Specifically, `suf[i]` = how many characters of `word2` from the right can be matched starting at `word1[i]` going to the end.

2. Greedily match from the left (to minimize indices): traverse `word1` left to right, trying to match `word2[j]` exactly. If we haven't used our one allowed change yet and `suf[i] >= word2.length - j - 1` (meaning the remaining suffix after current position can be completed), we can use our one change at position `i` and pick indices greedily.

**Steps:**
- Build `suf[]` array from right to left.
- Traverse `word1` left to right, greedily matching characters of `word2`, using the one allowed mismatch optimally.

## Complexity

- **Time:** O(n + m) where n = len(word1), m = len(word2).
- **Space:** O(n + m).
