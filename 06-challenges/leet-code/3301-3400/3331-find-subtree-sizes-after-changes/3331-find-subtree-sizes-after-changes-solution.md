# 3331. Find Subtree Sizes After Changes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-subtree-sizes-after-changes/

---

## Solution: DFS + Ancestor Character Stack — O(n) time, O(n) space

**Idea:** Since changes happen simultaneously and each node re-parents to the **closest** ancestor with the same character, we can simulate the final tree in a single DFS from the root. While traversing, maintain a stack per character (26 total) recording the most recent ancestor seen with that character. When we enter node `x`, if the stack for `s[x]` is non-empty, its top is the new parent of `x` in the final tree. After re-parenting, we push `x` onto the stack for `s[x]`. On backtrack, we pop `x` off. After the final tree is known, a second DFS computes subtree sizes bottom-up.

The key observation is that because the original tree is traversed in DFS (pre-order), ancestors are always processed before descendants, so the character-stack correctly reflects the ancestor chain at any point.

**Algorithm:**
1. Build the original adjacency list from `parent`.
2. DFS from node 0, maintaining `charStack[c]` = stack of ancestor nodes whose character is `c`.
3. At node `x` (x ≠ 0): if `charStack[s[x]]` is non-empty, set the new parent `newParent[x] = charStack[s[x]].top()`.
4. Push `x` onto `charStack[s[x]]` and recurse on original children, then pop on backtrack.
5. Build the final adjacency list from `newParent`.
6. DFS again to compute subtree sizes: `size[x] = 1 + sum of size[child] for all children in final tree`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — two DFS passes, each O(n) |
| Space | O(n) — recursion stack + character stacks + adjacency lists |
