# 1111. Maximum Nesting Depth of Two Valid Parentheses Strings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

---

## Solution: Parity Split — O(n) time, O(n) space

**Idea:** To minimise `max(depth(A), depth(B))`, assign odd-depth open brackets to group A and even-depth to group B (or vice versa). This interleaves the brackets so the two subsequences each carry alternating levels and their depths are at most ⌈depth/2⌉.

**Algorithm:**
1. Track the current nesting depth with a counter, starting at 0.
2. For each character in `seq`:
   - If `'('`: increment depth, then assign to group `depth % 2` (0 → A, 1 → B).
   - If `')'`: assign to the same group as its matching `'('` (which is `depth % 2`), then decrement depth.
   - Otherwise: assign 0.
3. Return the assignment array.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — the result array |
