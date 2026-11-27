# 2131. Longest Palindrome by Concatenating Two Letter Words — Solution

**Link:** https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/

## Approach: Frequency Map

For each word `w`, its reverse `r` can be paired with it to form a palindrome contribution.

- **Non-palindrome words** (e.g., "lc"/"cl"): count pairs of `w` and its reverse; each pair adds 4 to length.
- **Palindrome words** (e.g., "gg"): can pair two of them symmetrically (adds 4 each pair); one remaining palindrome word can go in the center (adds 2).

Steps:
1. Build a frequency map.
2. For non-palindromic words, pair `w` with `reverse(w)` using `min(count[w], count[r])`.
3. For palindromic words (both chars same), use floor pairs and track if any single palindromic word remains for center.

## Complexity

| | Time | Space |
|---|---|---|
| **Frequency Map** | O(n) | O(n) |

Where `n` is the number of words.
