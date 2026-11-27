# 2018. Check if Word Can Be Placed In Crossword

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/

---

## Problem Statement

You are given an `m x n` matrix `board`, where each cell is one of: a **letter**, `' '` (blank), or `'#'` (blocked). A word can be placed **horizontally** or **vertically** in the board if: every cell occupied is a blank or matches the letter, and the cells immediately before/after the word are blocked or at boundary. Return `true` if the word can be placed.

---

## Examples

**Example 1:**
```
Input:  board = [["#"," ","#"],[" "," ","#"],["#","c"," "]], word = "abc"
Output: true
```

**Example 2:**
```
Input:  board = [[" ","#","a"],[" ","#","c"],[" ","#","a"]], word = "ac"
Output: false
```

**Example 3:**
```
Input:  board = [["#", " "], [" ", "#"]], word = "a"
Output: true
```

---

## Constraints

- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 200`
- `board[i][j] is one of ' ', '#', or lowercase English letters.`
- `1 <= word.length <= max(m, n)`
