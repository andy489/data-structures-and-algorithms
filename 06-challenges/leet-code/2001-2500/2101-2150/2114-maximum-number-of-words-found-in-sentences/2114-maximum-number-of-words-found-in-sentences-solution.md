# 2114. Maximum Number of Words Found in Sentences — Solution

**Link:** https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

## Approach: Count Spaces + 1

Since words are separated by single spaces with no leading/trailing spaces, the number of words in a sentence equals the number of spaces plus 1. We iterate over all sentences, count spaces (or split by space), and track the maximum.

## Complexity

| | Time | Space |
|---|---|---|
| **Split approach** | O(n * L) | O(1) |

Where `n` is the number of sentences and `L` is the average sentence length.
