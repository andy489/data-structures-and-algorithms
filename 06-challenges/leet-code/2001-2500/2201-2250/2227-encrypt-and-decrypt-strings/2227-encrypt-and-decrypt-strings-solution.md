# 2227. Encrypt and Decrypt Strings — Solution

**Approach:** Encrypt Dictionary at Construction Time

Pre-encrypt all dictionary words at construction time and store their counts in a frequency map. `encrypt` is straightforward lookup. For `decrypt`, instead of trying to decrypt `word2`, we return the count of `word2` in the pre-encrypted dictionary map.

**Time Complexity:**
- Constructor: O(d * L) where d = dictionary size, L = max word length
- encrypt: O(L)
- decrypt: O(1)

**Space Complexity:** O(d * L) for the pre-encrypted map.
