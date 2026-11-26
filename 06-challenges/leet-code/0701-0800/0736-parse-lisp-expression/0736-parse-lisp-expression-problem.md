# 736. Parse Lisp Expression

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/parse-lisp-expression/

---

## Problem Statement

You are given a string `expression` representing a Lisp-like expression that returns an integer.

The syntax of these expressions includes:
- An expression is either an integer, a `let` expression, an `add` expression, a `mult` expression, or a variable.
- `(let v1 e1 v2 e2 ... vn en expr)`: assigns `ei` to variable `vi` and returns `expr`.
- `(add e1 e2)`: returns the sum of `e1` and `e2`.
- `(mult e1 e2)`: returns the product of `e1` and `e2`.

---

## Examples

**Example 1:**
```
Input:  expression = "(let x 2 (mult x (let x 3 y 4 (add x y))))"
Output: 14
```

**Example 2:**
```
Input:  expression = "(let x 3 x 2 x)"
Output: 2
```

---

## Constraints

- `1 <= expression.length <= 2000`
- There are no leading or trailing spaces.
- All variable names are lowercase.
- All integers are in `[-1000, 1000]`.
- The answer is in `[-10^6, 10^6]`.
