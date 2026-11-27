# 1717. Maximum Score From Removing Substrings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-score-from-removing-substrings/

---

## Solution: Greedy Stack — O(n) time, O(n) space

**Idea:** Remove the higher-valued pair first, then the lower-valued pair. Use a stack-based approach: scan the string, and whenever the top of the stack with the current character forms the target pair, pop and score. Do this twice — once for the higher-value pair, then for the lower-value pair on the remaining string.

**Algorithm:**
1. Determine which pair (`"ab"` or `"ba"`) has higher value.
2. First pass: use a stack to greedily remove the higher-valued pair.
3. Second pass: on the remaining string (from stack), remove the lower-valued pair.
4. Sum the points.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear passes |
| Space | O(n) — stack storage |
