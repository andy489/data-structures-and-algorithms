# Solution: Count of Substrings Containing Every Vowel and K Consonants I

## Approach: Sliding Window (atLeast trick)

Use the formula: `count(exactly k consonants) = count(at least k) - count(at least k+1)`.

Implement a helper function that counts substrings with all 5 vowels and **at least** `minK` consonants using a two-pointer sliding window.

**Helper(minK):**
- Maintain a window with vowel frequencies and consonant count.
- For each right pointer `r`, expand the window; whenever vowels are all present and consonants >= minK, all extensions of the current left `l` to right `r` count. Add `l` to result, then advance `l`.

**Main:** Return `atLeast(k) - atLeast(k+1)`.

Small constraints (n <= 250) also allow O(n^2) brute force.

## Complexity

- **Time:** O(n) for two-pointer approach.
- **Space:** O(1).
