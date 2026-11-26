# 95. Unique Binary Search Trees II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/unique-binary-search-trees-ii/

---

## Solution: Divide and Conquer (Recursion) — O(Cₙ · n) time, O(Cₙ · n) space

**Idea:** For each value `i` in range `[lo, hi]` chosen as root, recursively generate all valid left subtrees from `[lo, i-1]` and all valid right subtrees from `[i+1, hi]`. Combine every (left, right) pair with a new root node. The base case `lo > hi` returns a list containing `null` (empty subtree).

**Algorithm:**
1. Define `generate(lo, hi)` returning a list of all BST roots for node values `lo..hi`.
2. Base case: if `lo > hi`, return `[null]`.
3. For each `i` from `lo` to `hi`:
   - Recurse: `lefts = generate(lo, i-1)`, `rights = generate(i+1, hi)`.
   - For each `(l, r)` pair: create a new node `i`, set `left = l`, `right = r`, add to result.
4. Call `generate(1, n)`.

**Complexity:**

| | |
|---|---|
| Time | O(Cₙ · n) — Cₙ trees each with n nodes; Cₙ is the nth Catalan number |
| Space | O(Cₙ · n) — total nodes across all output trees; recursion stack O(n) |

---

## Solution 2: Memoized Recursion — O(Cₙ · n) time, O(Cₙ · n) space

**Idea:** Same divide-and-conquer, but cache results for each `(lo, hi)` pair to avoid recomputing identical subproblems. Since actual node values matter (the nodes themselves differ), this only helps when the same *shape* with the same *offset* is requested multiple times — beneficial mainly for repeated calls or when extended to large n.

**Algorithm:**
1. Use a map `memo[(lo, hi)] -> list of roots`.
2. On each call, check memo first; if present return the cached list.
3. Otherwise compute as in Solution 1, store in memo, and return.

**Complexity:**

| | |
|---|---|
| Time | O(Cₙ · n) — same asymptotic; memoization prunes duplicate subranges |
| Space | O(Cₙ · n) — memo table plus output trees |
