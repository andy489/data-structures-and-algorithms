# Solution: 2586. Count the Number of Vowel Strings in Range

## Approach

Iterate through the subarray `words[left..right]` and count strings that both start and end with a vowel.

A set of vowels `{a, e, i, o, u}` is used for O(1) lookup. For each word in range, check if the first and last characters are both in the vowel set.

## Complexity

- **Time:** O(r - l + 1) where r = right, l = left
- **Space:** O(1) extra space (vowel set is constant size)
