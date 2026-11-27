# 1106. Parsing A Boolean Expression

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/parsing-a-boolean-expression/

---

## Problem Statement

A boolean expression is an expression that evaluates to either `true` or `false`. It can be one of:

- `'t'` — evaluates to `True`
- `'f'` — evaluates to `False`
- `'!(subExpr)'` — evaluates to the logical NOT of the inner expression
- `'&(subExpr1, subExpr2, ..., subExprn)'` — evaluates to the logical AND of 2 or more inner expressions
- `'|(subExpr1, subExpr2, ..., subExprn)'` — evaluates to the logical OR of 2 or more inner expressions

Given a string `expression` that represents a boolean expression, return the evaluation of that expression.

---

## Examples

**Example 1:**
```
Input:  expression = "&(|(f))"
Output: false
```

**Example 2:**
```
Input:  expression = "|(f,f,f,t)"
Output: true
```

**Example 3:**
```
Input:  expression = "!(&(f,t))"
Output: true
```

---

## Constraints

- `1 <= expression.length <= 20000`
- `expression[i]` is one of `'('`, `')'`, `'&'`, `'|'`, `'!'`, `'t'`, `'f'`, `','`
- `expression` is a valid expression representing a boolean, as given in the description.
