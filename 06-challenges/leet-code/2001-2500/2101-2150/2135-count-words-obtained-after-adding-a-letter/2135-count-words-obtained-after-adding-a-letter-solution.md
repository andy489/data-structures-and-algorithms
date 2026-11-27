# 2135. Count Words Obtained After Adding a Letter — Solution

**Link:** https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/

## Approach: Bitmask Set

Since each word has unique letters and at most 26 characters, represent each word as a bitmask (bit `i` set if letter `i` is present).

1. Store all bitmasks from `startWords` in a HashSet.
2. For each word in `targetWords`, compute its bitmask. Try removing each bit (each letter) — if the resulting bitmask exists in the set, this target is reachable.

This is O(26) per target word.

## Complexity

| | Time | Space |
|---|---|---|
| **Bitmask Set** | O(26 * (s + t)) | O(s) |

Where `s = startWords.length` and `t = targetWords.length`.
