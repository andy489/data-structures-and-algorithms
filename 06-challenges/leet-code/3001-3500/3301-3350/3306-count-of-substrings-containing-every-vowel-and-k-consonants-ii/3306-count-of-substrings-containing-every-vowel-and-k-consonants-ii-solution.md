# Solution: Count of Substrings Containing Every Vowel and K Consonants II

## Approach: Sliding Window (atLeast trick)

Same approach as problem 3305 but with larger constraints (n up to 2*10^5), requiring O(n) solution.

Use `count(exactly k) = atLeast(k) - atLeast(k+1)` with a two-pointer sliding window:

**atLeast(minK):** Maintain a window tracking vowel frequencies and consonant count. For each right pointer, when all 5 vowels are present and consonants >= minK, every extension to the right also satisfies the condition, so add `(n - r)` to result, then advance the left pointer.

## Complexity

- **Time:** O(n) — two linear passes (one for each call to atLeast).
- **Space:** O(1).
