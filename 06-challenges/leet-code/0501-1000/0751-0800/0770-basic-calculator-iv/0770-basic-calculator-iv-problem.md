# 770. Basic Calculator IV

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/basic-calculator-iv/

---

## Problem Statement

Given an expression such as `expression = "e + 8 - a + 5"` and an evaluation map such as `{"e": 1}` (given in terms of `evalvars` and `evalints`), return the result, in the form of a list of tokens in the format `[term1, term2, ...]` where each `termi` is `[coefficient, v1, v2, ..., vk]` such that the coefficient is a non-zero integer, and the monomials `v1, v2, ..., vk` are **sorted lexicographically**.

For example, if the expression evaluates to `-2 + 3*a - 4*b + 5*a*b`, we return `[[-2], [3, "a"], [-4, "b"], [5, "a", "b"]]`.

---

## Examples

**Example 1:**
```
Input:  expression = "e + 8 - a + 5", evalvars = ["e"], evalints = [1]
Output: [[-1,"a"],[14]]
```

**Example 2:**
```
Input:  expression = "e * e", evalvars = ["e"], evalints = [3]
Output: [[9]]
```

---

## Constraints

- `1 <= expression.length <= 250`
- `expression` consists of lowercase letters, digits, `'+'`, `'-'`, `'*'`, `'('`, `')'`, and `' '`.
- `expression` does not contain any leading or trailing spaces.
- All the tokens are separated by exactly one space.
- `0 <= evalvars.length <= 100`
- `1 <= evalvars[i].length <= 20`
- `0 <= evalints[i] <= 100`
