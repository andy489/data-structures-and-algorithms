# 652. Find Duplicate Subtrees — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-duplicate-subtrees/

---

## Solution: Serialize + HashMap — O(n²) time, O(n²) space

**Idea:** Serialize each subtree as a string and use a HashMap to count occurrences. When a serialization is seen for the second time, add the node to the result.

**Algorithm:**
1. DFS post-order traversal.
2. Serialize each node as `"left,right,val"`.
3. Track count in a map; add to result when count becomes 2.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — string concatenation at each node |
| Space | O(n²) — storing serializations |
