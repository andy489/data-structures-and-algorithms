# 2129. Capitalize the Title — Solution

**Link:** https://leetcode.com/problems/capitalize-the-title/

## Approach: Split and Transform

Split the title into words, then for each word apply the rule:
- Length <= 2: convert to lowercase
- Length >= 3: capitalize first letter, lowercase the rest

Join the processed words back with spaces.

## Complexity

| | Time | Space |
|---|---|---|
| **Split + Transform** | O(n) | O(n) |

Where `n` is the length of the title string.
