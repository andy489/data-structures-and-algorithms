# 2003. Smallest Missing Genetic Value in Each Subtree — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree/

---

## Solution: DFS from Node with Value 1 — O(n) time, O(n) space

**Idea:** Only the path from the node containing value 1 to the root matters. Walk up from that node, merging sets.

**Algorithm:**
1. Find node with `nums[node] == 1`.
2. Walk from that node to root, maintaining a visited set.
3. For each node on this path, the answer is the mex of the current visited set; all others have answer 1.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
