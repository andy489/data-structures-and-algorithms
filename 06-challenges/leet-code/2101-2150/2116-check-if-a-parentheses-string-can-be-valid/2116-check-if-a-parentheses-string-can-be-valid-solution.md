# 2116. Check if a Parentheses String Can Be Valid — Solution

**Link:** https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/

## Approach: Two-Pass Greedy (Balance Range)

If `n` is odd, return `false` immediately.

**Left-to-right pass:** Track the range `[lo, hi]` of possible open-paren balance counts:
- Unlocked `'0'`: can be `'('` (hi++) or `')'` (lo--)
- Locked `'('`: both lo++ and hi++
- Locked `')'`: both lo-- and hi--
- If `hi < 0` at any point, return `false` (too many required `)`).
- Clamp `lo = max(lo, 0)` (balance can't be negative).

After the full pass, return `lo == 0` (can the balance reach 0).

## Complexity

| | Time | Space |
|---|---|---|
| **Two-Pass Greedy** | O(n) | O(1) |
