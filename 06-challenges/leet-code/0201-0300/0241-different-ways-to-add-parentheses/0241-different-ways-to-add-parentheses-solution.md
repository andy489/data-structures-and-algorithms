# 241. Different Ways to Add Parentheses — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/different-ways-to-add-parentheses/

---

## Solution: Divide & Conquer + Memoization — O(n · Catalan(n)) time

**Idea:** For every operator in the expression, recursively solve the left and right subexpressions, then combine all pairs of results with the operator. Memoize by substring to avoid recomputation.

**Algorithm:**
1. Scan for operator characters in `expression`.
2. For each operator at position `i`: recursively compute all results for `expression[0..i-1]` and `expression[i+1..]`.
3. Combine every left result with every right result using the operator.
4. If no operator found (pure number), return `[parseInt(expression)]`.
5. Cache by `(start, end)` indices.

**Complexity:**

| | |
|---|---|
| Time | O(n · Catalan(n)) — bounded by Catalan number of groupings |
| Space | O(n² · Catalan(n)) — memoization table |
