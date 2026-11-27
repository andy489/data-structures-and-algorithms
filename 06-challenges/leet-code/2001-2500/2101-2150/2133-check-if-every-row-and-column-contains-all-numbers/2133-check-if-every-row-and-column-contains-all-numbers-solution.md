# 2133. Check if Every Row and Column Contains All Numbers — Solution

**Link:** https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/

## Approach: Set Validation

For each row and each column, check that it contains exactly the set `{1, 2, ..., n}`. Use a HashSet to detect duplicates — if the set size equals `n` after adding all elements, the row/column is valid.

## Complexity

| | Time | Space |
|---|---|---|
| **Set Validation** | O(n^2) | O(n) |

Where `n` is the matrix dimension.
