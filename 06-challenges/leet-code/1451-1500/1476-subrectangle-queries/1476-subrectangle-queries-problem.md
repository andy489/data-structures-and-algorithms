# 1476. Subrectangle Queries

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/subrectangle-queries/

---

## Problem Statement

Implement SubrectangleQueries: updateSubrectangle(row1,col1,row2,col2,newValue), getValue(row,col).

---

## Examples

**Example 1:**
```
Input:  SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]) → updateSubrectangle(0,0,3,2,5), getValue(0,0)=5, getValue(0,2)=5, updateSubrectangle(1,1,2,2,10), getValue(0,2)=5, getValue(1,1)=10
Output: null
```

---

## Constraints

- `1 <= rows, cols <= 100`
- `rows == rectangle.length`
- `cols == rectangle[i].length`
- `0 <= row1 <= row2 < rows`
- `0 <= col1 <= col2 < cols`
- `1 <= newValue, rectangle[i][j] <= 10^9`
- `At most 500 operations`
