# 1096. Brace Expansion II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/brace-expansion-ii/

---

## Solution: Recursive Parsing — O(n * 2^(n/2)) time, O(2^(n/2)) space

**Idea:** Parse the expression recursively. At each level, maintain a set of current strings. Union on comma, Cartesian product on concatenation.

**Algorithm:**
1. Use a recursive descent parser.
2. parseExpr = parseGroup*. parseGroup = {parseExpr(,parseExpr)*} | letter.
3. Use sets and sorting for deduplication.

**Complexity:**

| | |
|---|---|
| Time | O(n * 2^(n/2)) |
| Space | O(2^(n/2)) |
