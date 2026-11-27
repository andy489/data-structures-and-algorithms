# 3939. Count Non Adjacent Subsets in a Rooted Tree

## Approach

Tree DP with modular arithmetic. For each node, define:
- `dp[node][included][rem]` = number of ways to select a valid subset in the subtree rooted at `node`, where `included` is 1 if `node` itself is selected and 0 otherwise, and `rem` is the current sum modulo `k`.

Transitions when combining a node with its children:
- If the node is included (`included = 1`), none of its children can be included.
- If the node is not included (`included = 0`), each child can independently be included or not.

Merge children one by one using convolution on the remainder dimension.

Base case (leaf node):
- `dp[leaf][1][nums[leaf] % k] = 1`
- `dp[leaf][0][0] = 1`

After computing all DPs, the answer is the sum over all nodes of `dp[node][0][0] + dp[node][1][0]` minus 1 (to exclude the empty subset), but we need to be careful about merging subtrees.

Actually compute at root: answer = `dp[root][0][0] + dp[root][1][0] - 1` (subtract 1 for the empty set).

## Complexity

- **Time:** O(n^2 * k) — merging subtrees with DP
- **Space:** O(n * k) — DP tables
