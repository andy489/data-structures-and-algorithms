# 3484. Design Spreadsheet

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-spreadsheet/

---

## Problem Statement

A spreadsheet is a grid with 26 columns (labeled from `'A'` to `'Z'`) and a given number of `rows`. Each cell in the spreadsheet can hold an integer value between 0 and 10^5.

Implement the `Spreadsheet` class:

- `Spreadsheet(int rows)` Initializes a spreadsheet with 26 columns and the specified number of rows. All cells are initially set to 0.
- `void setCell(String cell, int value)` Sets the value of the specified cell. The cell reference is provided in the format `"AX"` (e.g., `"A1"`, `"B10"`), where the letter represents the column (`'A'` to `'Z'`) and the number represents a **1-indexed** row.
- `void resetCell(String cell)` Resets the specified cell to 0.
- `int getValue(String formula)` Evaluates a formula of the form `"=X+Y"`, where `X` and `Y` are **either** cell references or non-negative integers, and returns the computed sum.

**Note:** If `getValue` references a cell that has not been explicitly set using `setCell`, its value is considered 0.

---

## Examples

**Example 1:**
```
Input:
["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]
[[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ["A1"], ["=A1+B2"]]

Output:
[null, 12, null, 16, null, 25, null, 15]
```

---

## Constraints

- `1 <= rows <= 10^3`
- `0 <= value <= 10^5`
- The formula is always in the format `"=X+Y"`, where `X` and `Y` are valid cell references or non-negative integers <= 10^5.
- At most `10^4` calls total to `setCell`, `resetCell`, and `getValue`.
