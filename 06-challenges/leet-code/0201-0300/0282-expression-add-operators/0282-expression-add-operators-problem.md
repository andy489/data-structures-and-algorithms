# 282. Expression Add Operators

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/expression-add-operators/

---

## Problem Statement

Given a string `num` that contains only digits and an integer `target`, return **all possibilities** to insert the binary operators `'+'`, `'-'`, and/or `'*'` between the digits of `num` so that the resultant expression evaluates to the `target` value.

Note that operands in the returned expressions **should not** contain leading zeros.

---

## Examples

**Example 1:**
```
Input:  num = "123", target = 6
Output: ["1*2*3","1+2+3"]
```

**Example 2:**
```
Input:  num = "232", target = 8
Output: ["2*3+2","2+3*2"]
```

**Example 3:**
```
Input:  num = "3456237490", target = 9191
Output: []
```

---

## Constraints

- `1 <= num.length <= 10`
- `num` consists of only digits.
- `-2^31 <= target <= 2^31 - 1`
