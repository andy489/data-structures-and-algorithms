# 437. Path Sum III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/path-sum-iii/

---

## Solution: Prefix Sum with HashMap — O(n) time, O(n) space

**Idea:** Track the running prefix sum from root to current node. For each node, check how many previous prefix sums equal `currentSum - targetSum` — those are valid path starts. Use a HashMap to store prefix sum frequencies.

**Algorithm:**
1. DFS with a `prefixCounts` map, initialized with `{0: 1}` (empty path).
2. At each node, add its value to `currentSum`.
3. Count paths ending here: `prefixCounts.getOrDefault(currentSum - targetSum, 0)`.
4. Add `currentSum` to map, recurse left and right, then remove it (backtrack).

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(n) — recursion stack + prefix map |

---

## Solution 2: Brute Force DFS — O(n²) time, O(n) space

**Idea:** For every node, run a DFS counting paths starting at that node. Simple but quadratic.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — n nodes × O(n) each |
| Space | O(n) — recursion depth |
