# 608. Tree Node — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/tree-node/

---

## Solution: CASE Expression — O(n) time, O(n) space

**Idea:** Classify using a CASE expression: p_id IS NULL → Root; id appears in p_id column → Inner; otherwise Leaf.

**Complexity:**

| | |
|---|---|
| Time | O(n) — subquery is O(n), outer scan O(n) |
| Space | O(n) — subquery set |
