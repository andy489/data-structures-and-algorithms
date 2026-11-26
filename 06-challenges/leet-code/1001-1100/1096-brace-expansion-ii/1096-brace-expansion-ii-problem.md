# 1096. Brace Expansion II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/brace-expansion-ii/

---

## Problem Statement

Under the grammar given below, strings can represent a set of lowercase words. Let `R(expr)` denote the set of words the expression represents.

- An expression is a concatenation of some set of single lowercase letters.
- Two expressions can be joined using `{` and `}` with commas (a union operation).
- An expression may be surrounded with `{` and `}`.

Return the sorted list of unique words that the given expression represents.

---

## Examples

**Example 1:**
```
Input:  expression = "{a,b}{c,{d,e}}"
Output: ["ac","ad","ae","bc","bd","be"]
```

**Example 2:**
```
Input:  expression = "{{a,z},a{b,c},{ab,z}}"
Output: ["a","ab","ac","z"]
```

---

## Constraints

- `1 <= expression.length <= 60`
- `expression[i]` consists of `'{'`, `'}'`, `','`, or lowercase English letters.
