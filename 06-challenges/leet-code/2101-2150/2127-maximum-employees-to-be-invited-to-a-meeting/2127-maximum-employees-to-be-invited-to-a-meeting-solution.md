# 2127. Maximum Employees to Be Invited to a Meeting — Solution

**Link:** https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/

## Approach: Functional Graph — Cycle Detection + BFS Depth

The `favorite` array defines a functional graph (each node has out-degree 1). Every connected component has exactly one cycle.

**Two cases for the answer:**

**Case 1: Large cycle (length >= 3)**  
All nodes of the cycle can sit at the table. The answer is the max cycle length among all cycles with length >= 3.

**Case 2: 2-cycles (mutual favorites)**  
If `favorite[a] == b` and `favorite[b] == a`, we can extend each node of the 2-cycle with the longest chain leading into it (using reversed-graph BFS). We can merge multiple such 2-cycle chains around the table since they're placed on a line, not a full ring. Sum all their lengths.

**Algorithm:**
1. Detect all cycles using in-degree peeling (topological sort to remove non-cycle nodes).
2. For 2-cycles, BFS from each cycle node on the reversed graph (excluding the other cycle node) to find the max chain depth.
3. Answer = max(largest cycle >= 3, sum of all 2-cycle chain lengths).

## Complexity

| | Time | Space |
|---|---|---|
| **Functional Graph + BFS** | O(n) | O(n) |
