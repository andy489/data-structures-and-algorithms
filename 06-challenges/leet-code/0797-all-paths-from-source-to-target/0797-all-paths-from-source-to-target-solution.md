# 797. All Paths From Source to Target — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/all-paths-from-source-to-target/

---

## Solution: DFS Backtracking — O(2^n × n) time, O(2^n × n) space

**Idea:** DFS from node 0; at each node, explore all outgoing edges. Backtrack after exploring each branch. Since graph is DAG, no need for visited set.

**Algorithm:**
1. Start DFS from node 0 with path `[0]`.
2. At each node: if target (n-1), add copy of path to result.
3. Else: for each neighbor, append and recurse, then pop.

**Complexity:**

| | |
|---|---|
| Time | O(2^n × n) — exponential paths in DAG |
| Space | O(2^n × n) — output size |
