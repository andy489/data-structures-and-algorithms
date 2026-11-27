# 726. Number of Atoms

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-atoms/

---

## Problem Statement

Given a string `formula` representing a chemical formula, return the **count of each atom**.

The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

One or more digits representing its count may follow if the count is greater than `1`. If the count is omitted, assume it is `1`.

Two formulas concatenated together produce another formula.

A formula placed in parentheses, and a count (optionally added) is also a formula.

Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than `1`), followed by the second name (in sorted order), followed by its count (if that count is more than `1`), and so on.

---

## Examples

**Example 1:**
```
Input:  formula = "H2O"
Output: "H2O"
```

**Example 2:**
```
Input:  formula = "Mg(OH)2"
Output: "H2MgO2"
```

**Example 3:**
```
Input:  formula = "K4(ON(SO3)2)2"
Output: "K4N2O14S4"
```

---

## Constraints

- `1 <= formula.length <= 1000`
- `formula` consists of English letters, digits, `'('`, and `')'`.
- `formula` is always valid.
