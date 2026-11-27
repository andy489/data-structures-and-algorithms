# Solution for 3913. Sort Vowels by Frequency

## Approach

**Frequency sort with stable ordering:**

1. Identify all vowel positions in `s`.
2. Count the frequency of each vowel character.
3. Record the first occurrence index of each vowel for tie-breaking.
4. Collect the vowels at vowel positions.
5. Sort the vowel characters by: (-frequency, first_occurrence_index) to get non-increasing frequency with ties broken by first occurrence.
6. Place the sorted vowels back into the vowel positions.

## Complexity

- Time: O(n + V log V) where V = number of vowels (at most n)
- Space: O(n)
