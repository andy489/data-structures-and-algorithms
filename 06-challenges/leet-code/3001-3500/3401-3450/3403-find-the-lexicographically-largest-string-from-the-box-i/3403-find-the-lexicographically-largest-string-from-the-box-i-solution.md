# Solution: Find the Lexicographically Largest String From the Box I

## Approach

If numFriends == 1, the only "split" is the entire word itself, so return word.

Otherwise, the first piece in a split can start at any position from 0 to len-numFriends (leaving at least numFriends-1 characters for the remaining pieces). The first piece can extend from that start to at most len-numFriends+1 characters (the remaining numFriends-1 friends each get 1 character). So we enumerate all valid starting positions and maximum lengths for the first piece, track the lexicographically largest.

For any split, the first piece starts at index i and can have length up to `len - numFriends + 1 - i`. We want the maximum string over all such substrings.

Since we want the lex largest string from any piece, we can consider: for each position i, the substring `word[i..i + maxLen - 1]` where maxLen = len - numFriends + 1 - i + ... actually the maximum first piece length when starting at 0 is `len - (numFriends - 1)`. When starting at i > 0, we already gave i chars to previous pieces... Wait, we enumerate all possible substrings that can appear as a piece.

Key insight: a substring `word[i..j]` can be a piece if there are enough characters before i (at least numFriends-1 ... no wait). Actually any substring can be ANY of the numFriends pieces. The maximum length piece can appear as the FIRST piece starting at 0 of length up to `len - (numFriends - 1)`.

Simpler: iterate over all starting indices from 0 to len-1, the maximum length of the substring starting there is `min(len - i, len - (numFriends - 1))` = `len - max(i, numFriends - 1)`. Take max over all such substrings.

## Complexity

| | Complexity |
|---|---|
| Time | O(n^2) in worst case for string comparison |
| Space | O(n) |
