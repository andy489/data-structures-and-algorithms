# 1329. Sort the Matrix Diagonally — Solution

## Approach
Group elements by diagonal key (i-j). Sort each group and place back.

## Complexity
- Time: O(m*n*log(min(m,n)))
- Space: O(m*n)
