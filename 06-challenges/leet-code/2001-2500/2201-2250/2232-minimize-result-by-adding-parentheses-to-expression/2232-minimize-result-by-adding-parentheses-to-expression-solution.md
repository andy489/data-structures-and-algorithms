# 2232. Minimize Result by Adding Parentheses to Expression

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/minimize-result-by-adding-parentheses-to-expression/

## Approach: Brute Force Over All Parenthesis Positions

The expression is short (length <= 10), so we can try all valid placements of parentheses.

**Algorithm:**
1. Find the '+' position.
2. Try all positions i (0..plus) for the left parenthesis and all positions j (plus+1..end) for the right parenthesis.
3. The expression splits into: `A * (B + C) * D` where A is the prefix (or 1), B is left of '+', C is right of '+', D is suffix (or 1).
4. Evaluate each combination and track the minimum.
5. Return the arrangement that gives the minimum.

**Complexity:**
- Time: O(n^2) where n <= 10
- Space: O(n)
